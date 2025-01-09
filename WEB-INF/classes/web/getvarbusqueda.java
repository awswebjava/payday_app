package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getvarbusqueda extends GXProcedure
{
   public getvarbusqueda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getvarbusqueda.class ), "" );
   }

   public getvarbusqueda( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      getvarbusqueda.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      getvarbusqueda.this.AV8CliCod = aP0;
      getvarbusqueda.this.AV9OpeCliId = aP1;
      getvarbusqueda.this.AV15OpeCliVig = aP2;
      getvarbusqueda.this.aP3 = aP3;
      getvarbusqueda.this.aP4 = aP4;
      getvarbusqueda.this.aP5 = aP5;
      getvarbusqueda.this.aP6 = aP6;
      getvarbusqueda.this.aP7 = aP7;
      getvarbusqueda.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01TL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01TL2_A82OpeCliId[0] ;
         A3CliCod = P01TL2_A3CliCod[0] ;
         A1910VarBaseURL = P01TL2_A1910VarBaseURL[0] ;
         n1910VarBaseURL = P01TL2_n1910VarBaseURL[0] ;
         A1912VarScrapTipo = P01TL2_A1912VarScrapTipo[0] ;
         n1912VarScrapTipo = P01TL2_n1912VarScrapTipo[0] ;
         A1911VarScrapTDoc = P01TL2_A1911VarScrapTDoc[0] ;
         n1911VarScrapTDoc = P01TL2_n1911VarScrapTDoc[0] ;
         A1908VarBusGoogle = P01TL2_A1908VarBusGoogle[0] ;
         n1908VarBusGoogle = P01TL2_n1908VarBusGoogle[0] ;
         A1909VarBusWeb = P01TL2_A1909VarBusWeb[0] ;
         n1909VarBusWeb = P01TL2_n1909VarBusWeb[0] ;
         A1921VarScrapFin = P01TL2_A1921VarScrapFin[0] ;
         n1921VarScrapFin = P01TL2_n1921VarScrapFin[0] ;
         AV10VarBaseURL = A1910VarBaseURL ;
         AV11VarScrapTipo = A1912VarScrapTipo ;
         AV12VarScrapTDoc = A1911VarScrapTDoc ;
         AV13VarBusGoogle = A1908VarBusGoogle ;
         AV14VarBusWeb = A1909VarBusWeb ;
         AV19VarScrapFin = A1921VarScrapFin ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV16anioDosDig = (byte)(GXutil.year( AV17Fecha)-2000) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "1 &VarBusGoogle ", "")+AV13VarBusGoogle+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV15OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV21anteriorFecha = localUtil.ymdtod( GXutil.year( AV15OpeCliVig), GXutil.month( AV15OpeCliVig), 1) ;
      AV21anteriorFecha = GXutil.addmth( AV21anteriorFecha, (short)(-1)) ;
      AV20anteriorPalabra = GXutil.trim( GXutil.str( GXutil.month( AV21anteriorFecha), 10, 0)) + "/" + GXutil.trim( GXutil.str( GXutil.year( AV21anteriorFecha), 10, 0)) ;
      AV13VarBusGoogle = GXutil.strReplace( AV13VarBusGoogle, httpContext.getMessage( "%anterior(m/aaaa)", ""), AV20anteriorPalabra) ;
      AV13VarBusGoogle = GXutil.strReplace( AV13VarBusGoogle, httpContext.getMessage( "%m_3", ""), GXutil.substring( localUtil.cmonth( AV15OpeCliVig, httpContext.getLanguage( )), 1, 3)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "2 &VarBusGoogle ", "")+AV13VarBusGoogle+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV15OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV13VarBusGoogle = GXutil.strReplace( AV13VarBusGoogle, httpContext.getMessage( "%m", ""), localUtil.cmonth( AV15OpeCliVig, httpContext.getLanguage( ))) ;
      AV18anio4Dig = (short)(GXutil.year( AV15OpeCliVig)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "3 &VarBusGoogle ", "")+AV13VarBusGoogle+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV15OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " anio ", "")+GXutil.trim( GXutil.str( AV18anio4Dig, 4, 0))) ;
      AV13VarBusGoogle = GXutil.strReplace( AV13VarBusGoogle, httpContext.getMessage( "%aaaa", ""), GXutil.trim( GXutil.str( AV18anio4Dig, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "4 &VarBusGoogle ", "")+AV13VarBusGoogle+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV15OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV13VarBusGoogle = GXutil.strReplace( AV13VarBusGoogle, httpContext.getMessage( "%aa", ""), GXutil.trim( GXutil.str( AV16anioDosDig, 2, 0))) ;
      AV14VarBusWeb = GXutil.strReplace( AV14VarBusWeb, httpContext.getMessage( "%m_3", ""), GXutil.substring( localUtil.cmonth( AV15OpeCliVig, httpContext.getLanguage( )), 1, 3)) ;
      AV14VarBusWeb = GXutil.strReplace( AV14VarBusWeb, httpContext.getMessage( "%m", ""), localUtil.cmonth( AV15OpeCliVig, httpContext.getLanguage( ))) ;
      AV14VarBusWeb = GXutil.strReplace( AV14VarBusWeb, httpContext.getMessage( "%aaaa", ""), GXutil.trim( GXutil.str( GXutil.year( AV15OpeCliVig), 10, 0))) ;
      AV14VarBusWeb = GXutil.strReplace( AV14VarBusWeb, httpContext.getMessage( "%aa", ""), GXutil.trim( GXutil.str( AV16anioDosDig, 2, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getvarbusqueda.this.AV10VarBaseURL;
      this.aP4[0] = getvarbusqueda.this.AV11VarScrapTipo;
      this.aP5[0] = getvarbusqueda.this.AV12VarScrapTDoc;
      this.aP6[0] = getvarbusqueda.this.AV13VarBusGoogle;
      this.aP7[0] = getvarbusqueda.this.AV14VarBusWeb;
      this.aP8[0] = getvarbusqueda.this.AV19VarScrapFin;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10VarBaseURL = "" ;
      AV11VarScrapTipo = "" ;
      AV12VarScrapTDoc = "" ;
      AV13VarBusGoogle = "" ;
      AV14VarBusWeb = "" ;
      AV19VarScrapFin = "" ;
      scmdbuf = "" ;
      P01TL2_A82OpeCliId = new String[] {""} ;
      P01TL2_A3CliCod = new int[1] ;
      P01TL2_A1910VarBaseURL = new String[] {""} ;
      P01TL2_n1910VarBaseURL = new boolean[] {false} ;
      P01TL2_A1912VarScrapTipo = new String[] {""} ;
      P01TL2_n1912VarScrapTipo = new boolean[] {false} ;
      P01TL2_A1911VarScrapTDoc = new String[] {""} ;
      P01TL2_n1911VarScrapTDoc = new boolean[] {false} ;
      P01TL2_A1908VarBusGoogle = new String[] {""} ;
      P01TL2_n1908VarBusGoogle = new boolean[] {false} ;
      P01TL2_A1909VarBusWeb = new String[] {""} ;
      P01TL2_n1909VarBusWeb = new boolean[] {false} ;
      P01TL2_A1921VarScrapFin = new String[] {""} ;
      P01TL2_n1921VarScrapFin = new boolean[] {false} ;
      A82OpeCliId = "" ;
      A1910VarBaseURL = "" ;
      A1912VarScrapTipo = "" ;
      A1911VarScrapTDoc = "" ;
      A1908VarBusGoogle = "" ;
      A1909VarBusWeb = "" ;
      A1921VarScrapFin = "" ;
      AV17Fecha = GXutil.nullDate() ;
      AV25Pgmname = "" ;
      AV21anteriorFecha = GXutil.nullDate() ;
      AV20anteriorPalabra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getvarbusqueda__default(),
         new Object[] {
             new Object[] {
            P01TL2_A82OpeCliId, P01TL2_A3CliCod, P01TL2_A1910VarBaseURL, P01TL2_n1910VarBaseURL, P01TL2_A1912VarScrapTipo, P01TL2_n1912VarScrapTipo, P01TL2_A1911VarScrapTDoc, P01TL2_n1911VarScrapTDoc, P01TL2_A1908VarBusGoogle, P01TL2_n1908VarBusGoogle,
            P01TL2_A1909VarBusWeb, P01TL2_n1909VarBusWeb, P01TL2_A1921VarScrapFin, P01TL2_n1921VarScrapFin
            }
         }
      );
      AV25Pgmname = "getVarBusqueda" ;
      /* GeneXus formulas. */
      AV25Pgmname = "getVarBusqueda" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16anioDosDig ;
   private short AV18anio4Dig ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String AV11VarScrapTipo ;
   private String AV12VarScrapTDoc ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A1912VarScrapTipo ;
   private String A1911VarScrapTDoc ;
   private String AV25Pgmname ;
   private String AV20anteriorPalabra ;
   private java.util.Date AV15OpeCliVig ;
   private java.util.Date AV17Fecha ;
   private java.util.Date AV21anteriorFecha ;
   private boolean n1910VarBaseURL ;
   private boolean n1912VarScrapTipo ;
   private boolean n1911VarScrapTDoc ;
   private boolean n1908VarBusGoogle ;
   private boolean n1909VarBusWeb ;
   private boolean n1921VarScrapFin ;
   private String AV10VarBaseURL ;
   private String AV13VarBusGoogle ;
   private String AV14VarBusWeb ;
   private String AV19VarScrapFin ;
   private String A1910VarBaseURL ;
   private String A1908VarBusGoogle ;
   private String A1909VarBusWeb ;
   private String A1921VarScrapFin ;
   private String[] aP8 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01TL2_A82OpeCliId ;
   private int[] P01TL2_A3CliCod ;
   private String[] P01TL2_A1910VarBaseURL ;
   private boolean[] P01TL2_n1910VarBaseURL ;
   private String[] P01TL2_A1912VarScrapTipo ;
   private boolean[] P01TL2_n1912VarScrapTipo ;
   private String[] P01TL2_A1911VarScrapTDoc ;
   private boolean[] P01TL2_n1911VarScrapTDoc ;
   private String[] P01TL2_A1908VarBusGoogle ;
   private boolean[] P01TL2_n1908VarBusGoogle ;
   private String[] P01TL2_A1909VarBusWeb ;
   private boolean[] P01TL2_n1909VarBusWeb ;
   private String[] P01TL2_A1921VarScrapFin ;
   private boolean[] P01TL2_n1921VarScrapFin ;
}

final  class getvarbusqueda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TL2", "SELECT OpeCliId, CliCod, VarBaseURL, VarScrapTipo, VarScrapTDoc, VarBusGoogle, VarBusWeb, VarScrapFin FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

