package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpalabradetipoliq extends GXProcedure
{
   public getpalabradetipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpalabradetipoliq.class ), "" );
   }

   public getpalabradetipoliq( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getpalabradetipoliq.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getpalabradetipoliq.this.AV9CliCod = aP0;
      getpalabradetipoliq.this.AV8TLiqCod = aP1;
      getpalabradetipoliq.this.aP2 = aP2;
      getpalabradetipoliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P01ZR2_A32TLiqCod[0] ;
         A3CliCod = P01ZR2_A3CliCod[0] ;
         A2091TLiqCodFor = P01ZR2_A2091TLiqCodFor[0] ;
         AV10TLiqCodFor = A2091TLiqCodFor ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpalabradetipoliq.this.AV10TLiqCodFor;
      this.aP3[0] = getpalabradetipoliq.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TLiqCodFor = "" ;
      scmdbuf = "" ;
      P01ZR2_A32TLiqCod = new String[] {""} ;
      P01ZR2_A3CliCod = new int[1] ;
      P01ZR2_A2091TLiqCodFor = new String[] {""} ;
      A32TLiqCod = "" ;
      A2091TLiqCodFor = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpalabradetipoliq__default(),
         new Object[] {
             new Object[] {
            P01ZR2_A32TLiqCod, P01ZR2_A3CliCod, P01ZR2_A2091TLiqCodFor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8TLiqCod ;
   private String AV10TLiqCodFor ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String A2091TLiqCodFor ;
   private boolean AV11existe ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZR2_A32TLiqCod ;
   private int[] P01ZR2_A3CliCod ;
   private String[] P01ZR2_A2091TLiqCodFor ;
}

final  class getpalabradetipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZR2", "SELECT TLiqCod, CliCod, TLiqCodFor FROM TipoLiquidacion WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

