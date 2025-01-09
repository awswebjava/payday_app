package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvbusqueda extends GXProcedure
{
   public getconvbusqueda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvbusqueda.class ), "" );
   }

   public getconvbusqueda( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getconvbusqueda.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      getconvbusqueda.this.AV9CliPaiConve = aP0;
      getconvbusqueda.this.AV10CliConvenio = aP1;
      getconvbusqueda.this.AV15Fecha = aP2;
      getconvbusqueda.this.aP3 = aP3;
      getconvbusqueda.this.aP4 = aP4;
      getconvbusqueda.this.aP5 = aP5;
      getconvbusqueda.this.aP6 = aP6;
      getconvbusqueda.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01TU2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9CliPaiConve), AV10CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01TU2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01TU2_A1564CliPaiConve[0] ;
         A1915ConvBusGoogle = P01TU2_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = P01TU2_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = P01TU2_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = P01TU2_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = P01TU2_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = P01TU2_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = P01TU2_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = P01TU2_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = P01TU2_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = P01TU2_n1919ConvScrapTDoc[0] ;
         A3CliCod = P01TU2_A3CliCod[0] ;
         A1915ConvBusGoogle = P01TU2_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = P01TU2_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = P01TU2_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = P01TU2_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = P01TU2_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = P01TU2_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = P01TU2_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = P01TU2_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = P01TU2_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = P01TU2_n1919ConvScrapTDoc[0] ;
         AV12ConvBusGoogle = A1915ConvBusGoogle ;
         AV13ConvBusWeb = A1916ConvBusWeb ;
         AV14ConvBaseURL = A1917ConvBaseURL ;
         AV17ConvScrapTipo = A1918ConvScrapTipo ;
         AV18ConvScrapTDoc = A1919ConvScrapTDoc ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV16anioDosDig = (byte)(GXutil.year( AV15Fecha)-2000) ;
      AV13ConvBusWeb = GXutil.strReplace( AV13ConvBusWeb, httpContext.getMessage( "%d", ""), GXutil.trim( GXutil.str( GXutil.day( AV15Fecha), 10, 0))) ;
      AV13ConvBusWeb = GXutil.strReplace( AV13ConvBusWeb, httpContext.getMessage( "%m_3", ""), GXutil.substring( localUtil.cmonth( AV15Fecha, httpContext.getLanguage( )), 1, 3)) ;
      AV13ConvBusWeb = GXutil.strReplace( AV13ConvBusWeb, httpContext.getMessage( "%m", ""), localUtil.cmonth( AV15Fecha, httpContext.getLanguage( ))) ;
      AV13ConvBusWeb = GXutil.strReplace( AV13ConvBusWeb, httpContext.getMessage( "%aaaa", ""), GXutil.trim( GXutil.str( GXutil.year( AV15Fecha), 10, 0))) ;
      AV13ConvBusWeb = GXutil.strReplace( AV13ConvBusWeb, httpContext.getMessage( "%aa", ""), GXutil.trim( GXutil.str( AV16anioDosDig, 2, 0))) ;
      AV12ConvBusGoogle = GXutil.strReplace( AV12ConvBusGoogle, httpContext.getMessage( "%d", ""), GXutil.trim( GXutil.str( GXutil.day( AV15Fecha), 10, 0))) ;
      AV12ConvBusGoogle = GXutil.strReplace( AV12ConvBusGoogle, httpContext.getMessage( "%m_3", ""), GXutil.substring( localUtil.cmonth( AV15Fecha, httpContext.getLanguage( )), 1, 3)) ;
      AV12ConvBusGoogle = GXutil.strReplace( AV12ConvBusGoogle, httpContext.getMessage( "%m", ""), localUtil.cmonth( AV15Fecha, httpContext.getLanguage( ))) ;
      AV12ConvBusGoogle = GXutil.strReplace( AV12ConvBusGoogle, httpContext.getMessage( "%aaaa", ""), GXutil.trim( GXutil.str( GXutil.year( AV15Fecha), 10, 0))) ;
      AV12ConvBusGoogle = GXutil.strReplace( AV12ConvBusGoogle, httpContext.getMessage( "%aa", ""), GXutil.trim( GXutil.str( AV16anioDosDig, 2, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getconvbusqueda.this.AV12ConvBusGoogle;
      this.aP4[0] = getconvbusqueda.this.AV13ConvBusWeb;
      this.aP5[0] = getconvbusqueda.this.AV14ConvBaseURL;
      this.aP6[0] = getconvbusqueda.this.AV17ConvScrapTipo;
      this.aP7[0] = getconvbusqueda.this.AV18ConvScrapTDoc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ConvBusGoogle = "" ;
      AV13ConvBusWeb = "" ;
      AV14ConvBaseURL = "" ;
      AV17ConvScrapTipo = "" ;
      AV18ConvScrapTDoc = "" ;
      scmdbuf = "" ;
      P01TU2_A1565CliConvenio = new String[] {""} ;
      P01TU2_A1564CliPaiConve = new short[1] ;
      P01TU2_A1915ConvBusGoogle = new String[] {""} ;
      P01TU2_n1915ConvBusGoogle = new boolean[] {false} ;
      P01TU2_A1916ConvBusWeb = new String[] {""} ;
      P01TU2_n1916ConvBusWeb = new boolean[] {false} ;
      P01TU2_A1917ConvBaseURL = new String[] {""} ;
      P01TU2_n1917ConvBaseURL = new boolean[] {false} ;
      P01TU2_A1918ConvScrapTipo = new String[] {""} ;
      P01TU2_n1918ConvScrapTipo = new boolean[] {false} ;
      P01TU2_A1919ConvScrapTDoc = new String[] {""} ;
      P01TU2_n1919ConvScrapTDoc = new boolean[] {false} ;
      P01TU2_A3CliCod = new int[1] ;
      A1565CliConvenio = "" ;
      A1915ConvBusGoogle = "" ;
      A1916ConvBusWeb = "" ;
      A1917ConvBaseURL = "" ;
      A1918ConvScrapTipo = "" ;
      A1919ConvScrapTDoc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvbusqueda__default(),
         new Object[] {
             new Object[] {
            P01TU2_A1565CliConvenio, P01TU2_A1564CliPaiConve, P01TU2_A1915ConvBusGoogle, P01TU2_n1915ConvBusGoogle, P01TU2_A1916ConvBusWeb, P01TU2_n1916ConvBusWeb, P01TU2_A1917ConvBaseURL, P01TU2_n1917ConvBaseURL, P01TU2_A1918ConvScrapTipo, P01TU2_n1918ConvScrapTipo,
            P01TU2_A1919ConvScrapTDoc, P01TU2_n1919ConvScrapTDoc, P01TU2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16anioDosDig ;
   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV17ConvScrapTipo ;
   private String AV18ConvScrapTDoc ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1918ConvScrapTipo ;
   private String A1919ConvScrapTDoc ;
   private java.util.Date AV15Fecha ;
   private boolean n1915ConvBusGoogle ;
   private boolean n1916ConvBusWeb ;
   private boolean n1917ConvBaseURL ;
   private boolean n1918ConvScrapTipo ;
   private boolean n1919ConvScrapTDoc ;
   private String AV12ConvBusGoogle ;
   private String AV13ConvBusWeb ;
   private String AV14ConvBaseURL ;
   private String A1915ConvBusGoogle ;
   private String A1916ConvBusWeb ;
   private String A1917ConvBaseURL ;
   private String[] aP7 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01TU2_A1565CliConvenio ;
   private short[] P01TU2_A1564CliPaiConve ;
   private String[] P01TU2_A1915ConvBusGoogle ;
   private boolean[] P01TU2_n1915ConvBusGoogle ;
   private String[] P01TU2_A1916ConvBusWeb ;
   private boolean[] P01TU2_n1916ConvBusWeb ;
   private String[] P01TU2_A1917ConvBaseURL ;
   private boolean[] P01TU2_n1917ConvBaseURL ;
   private String[] P01TU2_A1918ConvScrapTipo ;
   private boolean[] P01TU2_n1918ConvScrapTipo ;
   private String[] P01TU2_A1919ConvScrapTDoc ;
   private boolean[] P01TU2_n1919ConvScrapTDoc ;
   private int[] P01TU2_A3CliCod ;
}

final  class getconvbusqueda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TU2", "SELECT T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T2.ConvBusGoogle, T2.ConvBusWeb, T2.ConvBaseURL, T2.ConvScrapTipo, T2.ConvScrapTDoc, T1.CliCod FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliPaiConve, T1.CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

