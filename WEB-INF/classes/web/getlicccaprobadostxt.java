package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlicccaprobadostxt extends GXProcedure
{
   public getlicccaprobadostxt( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlicccaprobadostxt.class ), "" );
   }

   public getlicccaprobadostxt( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 )
   {
      getlicccaprobadostxt.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             String[] aP5 )
   {
      getlicccaprobadostxt.this.AV8CliCod = aP0;
      getlicccaprobadostxt.this.AV9EmpCod = aP1;
      getlicccaprobadostxt.this.AV14LegNumero = aP2;
      getlicccaprobadostxt.this.AV11LegCuenLicTpo = aP3;
      getlicccaprobadostxt.this.AV10LegCuenAnio = aP4;
      getlicccaprobadostxt.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02C62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV14LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV10LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02C62_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02C62_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C62_A6LegNumero[0] ;
         A1EmpCod = P02C62_A1EmpCod[0] ;
         A3CliCod = P02C62_A3CliCod[0] ;
         A2326LegCuLAprLicOri = P02C62_A2326LegCuLAprLicOri[0] ;
         A2325LegCuLAprLicCnt = P02C62_A2325LegCuLAprLicCnt[0] ;
         A2324LegCuLAprLicFch = P02C62_A2324LegCuLAprLicFch[0] ;
         if ( ! (GXutil.strcmp("", AV15aprobadosTxt)==0) )
         {
            AV15aprobadosTxt += ". " ;
         }
         if ( GXutil.strcmp(A2326LegCuLAprLicOri, "inicializacion") == 0 )
         {
            AV15aprobadosTxt += GXutil.trim( GXutil.str( A2325LegCuLAprLicCnt, 4, 0)) + httpContext.getMessage( " días de ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainlic_orig_consumos.getDescription(httpContext,(String)A2326LegCuLAprLicOri), "")) ;
         }
         else
         {
            AV15aprobadosTxt += GXutil.trim( GXutil.str( A2325LegCuLAprLicCnt, 4, 0)) + httpContext.getMessage( " días de ", "") + GXutil.trim( localUtil.cmonth( A2324LegCuLAprLicFch, httpContext.getLanguage( ))) + httpContext.getMessage( " de ", "") + GXutil.trim( GXutil.str( GXutil.year( A2324LegCuLAprLicFch), 10, 0)) ;
            AV15aprobadosTxt += " (" + GXutil.trim( httpContext.getMessage( web.gxdomainlic_orig_consumos.getDescription(httpContext,(String)A2326LegCuLAprLicOri), "")) + ")" ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlicccaprobadostxt.this.AV15aprobadosTxt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15aprobadosTxt = "" ;
      scmdbuf = "" ;
      P02C62_A2266LegCuenAnio = new short[1] ;
      P02C62_A2243LegCuenLicTpo = new String[] {""} ;
      P02C62_A6LegNumero = new int[1] ;
      P02C62_A1EmpCod = new short[1] ;
      P02C62_A3CliCod = new int[1] ;
      P02C62_A2326LegCuLAprLicOri = new String[] {""} ;
      P02C62_A2325LegCuLAprLicCnt = new short[1] ;
      P02C62_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      A2243LegCuenLicTpo = "" ;
      A2326LegCuLAprLicOri = "" ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlicccaprobadostxt__default(),
         new Object[] {
             new Object[] {
            P02C62_A2266LegCuenAnio, P02C62_A2243LegCuenLicTpo, P02C62_A6LegNumero, P02C62_A1EmpCod, P02C62_A3CliCod, P02C62_A2326LegCuLAprLicOri, P02C62_A2325LegCuLAprLicCnt, P02C62_A2324LegCuLAprLicFch
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10LegCuenAnio ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2325LegCuLAprLicCnt ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2326LegCuLAprLicOri ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private String AV15aprobadosTxt ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02C62_A2266LegCuenAnio ;
   private String[] P02C62_A2243LegCuenLicTpo ;
   private int[] P02C62_A6LegNumero ;
   private short[] P02C62_A1EmpCod ;
   private int[] P02C62_A3CliCod ;
   private String[] P02C62_A2326LegCuLAprLicOri ;
   private short[] P02C62_A2325LegCuLAprLicCnt ;
   private java.util.Date[] P02C62_A2324LegCuLAprLicFch ;
}

final  class getlicccaprobadostxt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C62", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLAprLicOri, LegCuLAprLicCnt, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

