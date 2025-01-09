package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcatfecact extends GXProcedure
{
   public getcatfecact( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcatfecact.class ), "" );
   }

   public getcatfecact( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           String aP2 ,
                           String aP3 )
   {
      getcatfecact.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             byte[] aP4 )
   {
      getcatfecact.this.AV12CliCod = aP0;
      getcatfecact.this.AV11CliPaiConve = aP1;
      getcatfecact.this.AV9CliConvenio = aP2;
      getcatfecact.this.AV10CatCodigo = aP3;
      getcatfecact.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11CliPaiConve), AV9CliConvenio, AV10CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P02LX2_A8CatCodigo[0] ;
         A1565CliConvenio = P02LX2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02LX2_A1564CliPaiConve[0] ;
         A3CliCod = P02LX2_A3CliCod[0] ;
         A1914CatFrecAct = P02LX2_A1914CatFrecAct[0] ;
         AV8CatFrecAct = A1914CatFrecAct ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getcatfecact.this.AV8CatFrecAct;
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
      P02LX2_A8CatCodigo = new String[] {""} ;
      P02LX2_A1565CliConvenio = new String[] {""} ;
      P02LX2_A1564CliPaiConve = new short[1] ;
      P02LX2_A3CliCod = new int[1] ;
      P02LX2_A1914CatFrecAct = new byte[1] ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcatfecact__default(),
         new Object[] {
             new Object[] {
            P02LX2_A8CatCodigo, P02LX2_A1565CliConvenio, P02LX2_A1564CliPaiConve, P02LX2_A3CliCod, P02LX2_A1914CatFrecAct
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8CatFrecAct ;
   private byte A1914CatFrecAct ;
   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV9CliConvenio ;
   private String AV10CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02LX2_A8CatCodigo ;
   private String[] P02LX2_A1565CliConvenio ;
   private short[] P02LX2_A1564CliPaiConve ;
   private int[] P02LX2_A3CliCod ;
   private byte[] P02LX2_A1914CatFrecAct ;
}

final  class getcatfecact__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LX2", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatFrecAct FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

