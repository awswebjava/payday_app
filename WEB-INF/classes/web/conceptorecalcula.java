package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptorecalcula extends GXProcedure
{
   public conceptorecalcula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptorecalcula.class ), "" );
   }

   public conceptorecalcula( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      conceptorecalcula.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      conceptorecalcula.this.AV10CliCod = aP0;
      conceptorecalcula.this.AV9ConCodigo = aP1;
      conceptorecalcula.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00SQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00SQ2_A26ConCodigo[0] ;
         A3CliCod = P00SQ2_A3CliCod[0] ;
         A762ConRecalcular = P00SQ2_A762ConRecalcular[0] ;
         AV8ConRecalcular = A762ConRecalcular ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptorecalcula.this.AV8ConRecalcular;
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
      P00SQ2_A26ConCodigo = new String[] {""} ;
      P00SQ2_A3CliCod = new int[1] ;
      P00SQ2_A762ConRecalcular = new boolean[] {false} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptorecalcula__default(),
         new Object[] {
             new Object[] {
            P00SQ2_A26ConCodigo, P00SQ2_A3CliCod, P00SQ2_A762ConRecalcular
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV8ConRecalcular ;
   private boolean A762ConRecalcular ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00SQ2_A26ConCodigo ;
   private int[] P00SQ2_A3CliCod ;
   private boolean[] P00SQ2_A762ConRecalcular ;
}

final  class conceptorecalcula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SQ2", "SELECT ConCodigo, CliCod, ConRecalcular FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               return;
      }
   }

}

