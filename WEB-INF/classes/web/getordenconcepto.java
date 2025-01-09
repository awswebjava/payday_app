package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getordenconcepto extends GXProcedure
{
   public getordenconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getordenconcepto.class ), "" );
   }

   public getordenconcepto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          String aP1 )
   {
      getordenconcepto.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             int[] aP2 )
   {
      getordenconcepto.this.AV10clicod = aP0;
      getordenconcepto.this.AV9concodigo = aP1;
      getordenconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00G12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10clicod), AV9concodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00G12_A26ConCodigo[0] ;
         A3CliCod = P00G12_A3CliCod[0] ;
         A40ConOrden = P00G12_A40ConOrden[0] ;
         AV8conorden = A40ConOrden ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getordenconcepto.this.AV8conorden;
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
      P00G12_A26ConCodigo = new String[] {""} ;
      P00G12_A3CliCod = new int[1] ;
      P00G12_A40ConOrden = new int[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getordenconcepto__default(),
         new Object[] {
             new Object[] {
            P00G12_A26ConCodigo, P00G12_A3CliCod, P00G12_A40ConOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10clicod ;
   private int AV8conorden ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private String AV9concodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00G12_A26ConCodigo ;
   private int[] P00G12_A3CliCod ;
   private int[] P00G12_A40ConOrden ;
}

final  class getordenconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00G12", "SELECT ConCodigo, CliCod, ConOrden FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

}

