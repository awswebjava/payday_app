package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licccgetprcconsumido extends GXProcedure
{
   public licccgetprcconsumido( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licccgetprcconsumido.class ), "" );
   }

   public licccgetprcconsumido( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      licccgetprcconsumido.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      licccgetprcconsumido.this.AV8CliCod = aP0;
      licccgetprcconsumido.this.AV9EmpCod = aP1;
      licccgetprcconsumido.this.AV14LegNumero = aP2;
      licccgetprcconsumido.this.AV12LegCuenLicTpo = aP3;
      licccgetprcconsumido.this.AV10LegCuenAnio = aP4;
      licccgetprcconsumido.this.aP5 = aP5;
      licccgetprcconsumido.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      /* Using cursor P02C72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV14LegNumero), AV12LegCuenLicTpo, Short.valueOf(AV10LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2243LegCuenLicTpo = P02C72_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C72_A6LegNumero[0] ;
         A1EmpCod = P02C72_A1EmpCod[0] ;
         A3CliCod = P02C72_A3CliCod[0] ;
         A2266LegCuenAnio = P02C72_A2266LegCuenAnio[0] ;
         A2247LegCuenDiasCorres = P02C72_A2247LegCuenDiasCorres[0] ;
         A2315LegCuLActVen = P02C72_A2315LegCuLActVen[0] ;
         AV11LegCuenDiasCorres = A2247LegCuenDiasCorres ;
         if ( A2266LegCuenAnio < GXutil.year( AV18hoy) )
         {
            AV17LegCuLActVen = A2315LegCuLActVen ;
         }
         /* Using cursor P02C73 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2312LegCuLConsCnt = P02C73_A2312LegCuLConsCnt[0] ;
            A2327LegCuLConsOri = P02C73_A2327LegCuLConsOri[0] ;
            A2310LegCuLConsAnio = P02C73_A2310LegCuLConsAnio[0] ;
            A2311LegCuLConsSec = P02C73_A2311LegCuLConsSec[0] ;
            AV13LegCuLConsCnt = (short)(AV13LegCuLConsCnt+A2312LegCuLConsCnt) ;
            if ( ! (GXutil.strcmp("", AV16consumidosTxt)==0) )
            {
               AV16consumidosTxt += ". " ;
            }
            if ( GXutil.strcmp(A2327LegCuLConsOri, "inicializacion") == 0 )
            {
               AV16consumidosTxt += GXutil.trim( GXutil.str( A2312LegCuLConsCnt, 4, 0)) + httpContext.getMessage( " día", "") ;
               if ( A2312LegCuLConsCnt > 1 )
               {
                  AV16consumidosTxt += httpContext.getMessage( "s", "") ;
               }
               AV16consumidosTxt += httpContext.getMessage( " de ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainlic_orig_consumos.getDescription(httpContext,(String)A2327LegCuLConsOri), "")) ;
            }
            else
            {
               AV16consumidosTxt += GXutil.trim( GXutil.str( A2312LegCuLConsCnt, 4, 0)) + httpContext.getMessage( " día", "") ;
               if ( A2312LegCuLConsCnt > 1 )
               {
                  AV16consumidosTxt += httpContext.getMessage( "s", "") ;
               }
               if ( A2310LegCuLConsAnio == A2266LegCuenAnio )
               {
                  AV16consumidosTxt += httpContext.getMessage( " de periodo actual", "") ;
               }
               else
               {
                  AV16consumidosTxt += " " + GXutil.trim( GXutil.str( A2310LegCuLConsAnio, 4, 0)) ;
               }
               AV16consumidosTxt += " (" + GXutil.trim( httpContext.getMessage( web.gxdomainlic_orig_consumos.getDescription(httpContext,(String)A2327LegCuLConsOri), "")) + ")" ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( ! (0==AV17LegCuLActVen) )
         {
            if ( ! (GXutil.strcmp("", AV16consumidosTxt)==0) )
            {
               AV16consumidosTxt += ". " ;
            }
            AV13LegCuLConsCnt = (short)(AV13LegCuLConsCnt+AV17LegCuLActVen) ;
            AV16consumidosTxt += GXutil.trim( GXutil.str( AV17LegCuLActVen, 4, 0)) + httpContext.getMessage( " día", "") ;
            if ( AV17LegCuLActVen > 1 )
            {
               AV16consumidosTxt += httpContext.getMessage( "s", "") ;
            }
            AV16consumidosTxt += httpContext.getMessage( " con vencimiento.", "") ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( ! (0==AV11LegCuenDiasCorres) )
      {
         AV15porcentaje = GXutil.roundDecimal( DecimalUtil.doubleToDec(AV13LegCuLConsCnt/ (double) (AV11LegCuenDiasCorres)), 2) ;
         AV15porcentaje = AV15porcentaje.multiply(DecimalUtil.doubleToDec(100)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = licccgetprcconsumido.this.AV15porcentaje;
      this.aP6[0] = licccgetprcconsumido.this.AV16consumidosTxt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15porcentaje = DecimalUtil.ZERO ;
      AV16consumidosTxt = "" ;
      AV18hoy = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02C72_A2243LegCuenLicTpo = new String[] {""} ;
      P02C72_A6LegNumero = new int[1] ;
      P02C72_A1EmpCod = new short[1] ;
      P02C72_A3CliCod = new int[1] ;
      P02C72_A2266LegCuenAnio = new short[1] ;
      P02C72_A2247LegCuenDiasCorres = new short[1] ;
      P02C72_A2315LegCuLActVen = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      P02C73_A3CliCod = new int[1] ;
      P02C73_A1EmpCod = new short[1] ;
      P02C73_A6LegNumero = new int[1] ;
      P02C73_A2243LegCuenLicTpo = new String[] {""} ;
      P02C73_A2266LegCuenAnio = new short[1] ;
      P02C73_A2312LegCuLConsCnt = new short[1] ;
      P02C73_A2327LegCuLConsOri = new String[] {""} ;
      P02C73_A2310LegCuLConsAnio = new short[1] ;
      P02C73_A2311LegCuLConsSec = new short[1] ;
      A2327LegCuLConsOri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licccgetprcconsumido__default(),
         new Object[] {
             new Object[] {
            P02C72_A2243LegCuenLicTpo, P02C72_A6LegNumero, P02C72_A1EmpCod, P02C72_A3CliCod, P02C72_A2266LegCuenAnio, P02C72_A2247LegCuenDiasCorres, P02C72_A2315LegCuLActVen
            }
            , new Object[] {
            P02C73_A3CliCod, P02C73_A1EmpCod, P02C73_A6LegNumero, P02C73_A2243LegCuenLicTpo, P02C73_A2266LegCuenAnio, P02C73_A2312LegCuLConsCnt, P02C73_A2327LegCuLConsOri, P02C73_A2310LegCuLConsAnio, P02C73_A2311LegCuLConsSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10LegCuenAnio ;
   private short A1EmpCod ;
   private short A2266LegCuenAnio ;
   private short A2247LegCuenDiasCorres ;
   private short A2315LegCuLActVen ;
   private short AV11LegCuenDiasCorres ;
   private short AV17LegCuLActVen ;
   private short A2312LegCuLConsCnt ;
   private short A2310LegCuLConsAnio ;
   private short A2311LegCuLConsSec ;
   private short AV13LegCuLConsCnt ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV15porcentaje ;
   private String AV12LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2327LegCuLConsOri ;
   private java.util.Date AV18hoy ;
   private String AV16consumidosTxt ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02C72_A2243LegCuenLicTpo ;
   private int[] P02C72_A6LegNumero ;
   private short[] P02C72_A1EmpCod ;
   private int[] P02C72_A3CliCod ;
   private short[] P02C72_A2266LegCuenAnio ;
   private short[] P02C72_A2247LegCuenDiasCorres ;
   private short[] P02C72_A2315LegCuLActVen ;
   private int[] P02C73_A3CliCod ;
   private short[] P02C73_A1EmpCod ;
   private int[] P02C73_A6LegNumero ;
   private String[] P02C73_A2243LegCuenLicTpo ;
   private short[] P02C73_A2266LegCuenAnio ;
   private short[] P02C73_A2312LegCuLConsCnt ;
   private String[] P02C73_A2327LegCuLConsOri ;
   private short[] P02C73_A2310LegCuLConsAnio ;
   private short[] P02C73_A2311LegCuLConsSec ;
}

final  class licccgetprcconsumido__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C72", "SELECT LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenAnio, LegCuenDiasCorres, LegCuLActVen FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02C73", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsCnt, LegCuLConsOri, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

