package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcategoria2 extends GXProcedure
{
   public getcategoria2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcategoria2.class ), "" );
   }

   public getcategoria2( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      getcategoria2.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getcategoria2.this.AV10CliCod = aP0;
      getcategoria2.this.AV13PaiCod = aP1;
      getcategoria2.this.AV12ConveCodigo = aP2;
      getcategoria2.this.AV8CatCodigo = aP3;
      getcategoria2.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02022 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV13PaiCod), AV12ConveCodigo, AV8CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P02022_A8CatCodigo[0] ;
         A1565CliConvenio = P02022_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02022_A1564CliPaiConve[0] ;
         A3CliCod = P02022_A3CliCod[0] ;
         A123CatDescrip = P02022_A123CatDescrip[0] ;
         AV9CatDescrip = A123CatDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getcategoria2.this.AV9CatDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CatDescrip = "" ;
      scmdbuf = "" ;
      P02022_A8CatCodigo = new String[] {""} ;
      P02022_A1565CliConvenio = new String[] {""} ;
      P02022_A1564CliPaiConve = new short[1] ;
      P02022_A3CliCod = new int[1] ;
      P02022_A123CatDescrip = new String[] {""} ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      A123CatDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcategoria2__default(),
         new Object[] {
             new Object[] {
            P02022_A8CatCodigo, P02022_A1565CliConvenio, P02022_A1564CliPaiConve, P02022_A3CliCod, P02022_A123CatDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV12ConveCodigo ;
   private String AV8CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private String AV9CatDescrip ;
   private String A123CatDescrip ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02022_A8CatCodigo ;
   private String[] P02022_A1565CliConvenio ;
   private short[] P02022_A1564CliPaiConve ;
   private int[] P02022_A3CliCod ;
   private String[] P02022_A123CatDescrip ;
}

final  class getcategoria2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02022", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatDescrip FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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

