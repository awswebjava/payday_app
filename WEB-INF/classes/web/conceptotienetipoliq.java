package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptotienetipoliq extends GXProcedure
{
   public conceptotienetipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotienetipoliq.class ), "" );
   }

   public conceptotienetipoliq( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 )
   {
      conceptotienetipoliq.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      conceptotienetipoliq.this.AV8CliCod = aP0;
      conceptotienetipoliq.this.AV9ConCodigo = aP1;
      conceptotienetipoliq.this.AV10TLiqCod = aP2;
      conceptotienetipoliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01OI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo, AV10TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P01OI2_A32TLiqCod[0] ;
         A26ConCodigo = P01OI2_A26ConCodigo[0] ;
         A3CliCod = P01OI2_A3CliCod[0] ;
         AV11aplica = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = conceptotienetipoliq.this.AV11aplica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01OI2_A32TLiqCod = new String[] {""} ;
      P01OI2_A26ConCodigo = new String[] {""} ;
      P01OI2_A3CliCod = new int[1] ;
      A32TLiqCod = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotienetipoliq__default(),
         new Object[] {
             new Object[] {
            P01OI2_A32TLiqCod, P01OI2_A26ConCodigo, P01OI2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV10TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String A26ConCodigo ;
   private boolean AV11aplica ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01OI2_A32TLiqCod ;
   private String[] P01OI2_A26ConCodigo ;
   private int[] P01OI2_A3CliCod ;
}

final  class conceptotienetipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OI2", "SELECT TLiqCod, ConCodigo, CliCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) and TLiqCod = ( ?) ORDER BY CliCod, ConCodigo, TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

