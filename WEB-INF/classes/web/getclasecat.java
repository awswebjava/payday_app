package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclasecat extends GXProcedure
{
   public getclasecat( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclasecat.class ), "" );
   }

   public getclasecat( int remoteHandle ,
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
      getclasecat.this.aP4 = new byte[] {0};
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
      getclasecat.this.AV8CliCod = aP0;
      getclasecat.this.AV9CliPaiConve = aP1;
      getclasecat.this.AV12CliConvenio = aP2;
      getclasecat.this.AV11CatCodigo = aP3;
      getclasecat.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01T62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9CliPaiConve), AV12CliConvenio, AV11CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P01T62_A8CatCodigo[0] ;
         A1565CliConvenio = P01T62_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01T62_A1564CliPaiConve[0] ;
         A3CliCod = P01T62_A3CliCod[0] ;
         A1838CatClase = P01T62_A1838CatClase[0] ;
         AV10CatClase = A1838CatClase ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getclasecat.this.AV10CatClase;
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
      P01T62_A8CatCodigo = new String[] {""} ;
      P01T62_A1565CliConvenio = new String[] {""} ;
      P01T62_A1564CliPaiConve = new short[1] ;
      P01T62_A3CliCod = new int[1] ;
      P01T62_A1838CatClase = new byte[1] ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getclasecat__default(),
         new Object[] {
             new Object[] {
            P01T62_A8CatCodigo, P01T62_A1565CliConvenio, P01T62_A1564CliPaiConve, P01T62_A3CliCod, P01T62_A1838CatClase
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10CatClase ;
   private byte A1838CatClase ;
   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV12CliConvenio ;
   private String AV11CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01T62_A8CatCodigo ;
   private String[] P01T62_A1565CliConvenio ;
   private short[] P01T62_A1564CliPaiConve ;
   private int[] P01T62_A3CliCod ;
   private byte[] P01T62_A1838CatClase ;
}

final  class getclasecat__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01T62", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatClase FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

