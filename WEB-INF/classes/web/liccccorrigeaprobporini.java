package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liccccorrigeaprobporini extends GXProcedure
{
   public liccccorrigeaprobporini( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liccccorrigeaprobporini.class ), "" );
   }

   public liccccorrigeaprobporini( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            short aP4 ,
                            boolean[] aP5 )
   {
      liccccorrigeaprobporini.this.aP6 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean[] aP5 ,
                        short[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean[] aP5 ,
                             short[] aP6 )
   {
      liccccorrigeaprobporini.this.AV8CliCod = aP0;
      liccccorrigeaprobporini.this.AV9EmpCod = aP1;
      liccccorrigeaprobporini.this.AV10LegNumero = aP2;
      liccccorrigeaprobporini.this.AV11LegCuenLicTpo = aP3;
      liccccorrigeaprobporini.this.AV12LegCuenAnio = aP4;
      liccccorrigeaprobporini.this.aP5 = aP5;
      liccccorrigeaprobporini.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV13LegCuenDiasCorres ;
      new web.licccgetcorresponden(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV11LegCuenLicTpo, AV12LegCuenAnio, GXv_int1) ;
      liccccorrigeaprobporini.this.AV13LegCuenDiasCorres = GXv_int1[0] ;
      /* Using cursor P02C52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02C52_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02C52_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C52_A6LegNumero[0] ;
         A1EmpCod = P02C52_A1EmpCod[0] ;
         A3CliCod = P02C52_A3CliCod[0] ;
         A2326LegCuLAprLicOri = P02C52_A2326LegCuLAprLicOri[0] ;
         A2325LegCuLAprLicCnt = P02C52_A2325LegCuLAprLicCnt[0] ;
         A2324LegCuLAprLicFch = P02C52_A2324LegCuLAprLicFch[0] ;
         if ( GXutil.strcmp(A2326LegCuLAprLicOri, "manual") != 0 )
         {
            AV14LegCuLAprLicCnt = (short)(AV14LegCuLAprLicCnt+A2325LegCuLAprLicCnt) ;
         }
         else
         {
            AV19manualhay = true ;
         }
         if ( GXutil.strcmp(A2326LegCuLAprLicOri, "inicializacion") == 0 )
         {
            AV15iniHay = true ;
         }
         else
         {
            AV20aprobaciones = (short)(AV20aprobaciones+A2325LegCuLAprLicCnt) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "&iniHay ", "")+GXutil.trim( GXutil.booltostr( AV15iniHay))+httpContext.getMessage( " &LegCuLAprLicCnt ", "")+GXutil.trim( GXutil.str( AV14LegCuLAprLicCnt, 4, 0))+httpContext.getMessage( " &LegCuenDiasCorres ", "")+GXutil.trim( GXutil.str( AV13LegCuenDiasCorres, 4, 0))) ;
      if ( ! AV19manualhay && ( AV15iniHay ) && ( AV14LegCuLAprLicCnt > AV13LegCuenDiasCorres ) )
      {
         AV18corrigio = true ;
         AV16nuevoConsumoIni = (short)(AV14LegCuLAprLicCnt-AV13LegCuenDiasCorres) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "nuevoconsumo ", "")+GXutil.trim( GXutil.str( AV16nuevoConsumoIni, 4, 0))) ;
         /* Using cursor P02C53 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2326LegCuLAprLicOri = P02C53_A2326LegCuLAprLicOri[0] ;
            A2266LegCuenAnio = P02C53_A2266LegCuenAnio[0] ;
            A2243LegCuenLicTpo = P02C53_A2243LegCuenLicTpo[0] ;
            A6LegNumero = P02C53_A6LegNumero[0] ;
            A1EmpCod = P02C53_A1EmpCod[0] ;
            A3CliCod = P02C53_A3CliCod[0] ;
            A2324LegCuLAprLicFch = P02C53_A2324LegCuLAprLicFch[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "ini", "")) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "dlt", "")) ;
            /* Using cursor P02C54 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = liccccorrigeaprobporini.this.AV18corrigio;
      this.aP6[0] = liccccorrigeaprobporini.this.AV20aprobaciones;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new short[1] ;
      scmdbuf = "" ;
      P02C52_A2266LegCuenAnio = new short[1] ;
      P02C52_A2243LegCuenLicTpo = new String[] {""} ;
      P02C52_A6LegNumero = new int[1] ;
      P02C52_A1EmpCod = new short[1] ;
      P02C52_A3CliCod = new int[1] ;
      P02C52_A2326LegCuLAprLicOri = new String[] {""} ;
      P02C52_A2325LegCuLAprLicCnt = new short[1] ;
      P02C52_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      A2243LegCuenLicTpo = "" ;
      A2326LegCuLAprLicOri = "" ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      AV24Pgmname = "" ;
      P02C53_A2326LegCuLAprLicOri = new String[] {""} ;
      P02C53_A2266LegCuenAnio = new short[1] ;
      P02C53_A2243LegCuenLicTpo = new String[] {""} ;
      P02C53_A6LegNumero = new int[1] ;
      P02C53_A1EmpCod = new short[1] ;
      P02C53_A3CliCod = new int[1] ;
      P02C53_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liccccorrigeaprobporini__default(),
         new Object[] {
             new Object[] {
            P02C52_A2266LegCuenAnio, P02C52_A2243LegCuenLicTpo, P02C52_A6LegNumero, P02C52_A1EmpCod, P02C52_A3CliCod, P02C52_A2326LegCuLAprLicOri, P02C52_A2325LegCuLAprLicCnt, P02C52_A2324LegCuLAprLicFch
            }
            , new Object[] {
            P02C53_A2326LegCuLAprLicOri, P02C53_A2266LegCuenAnio, P02C53_A2243LegCuenLicTpo, P02C53_A6LegNumero, P02C53_A1EmpCod, P02C53_A3CliCod, P02C53_A2324LegCuLAprLicFch
            }
            , new Object[] {
            }
         }
      );
      AV24Pgmname = "LicCCCorrigeAprobPorIni" ;
      /* GeneXus formulas. */
      AV24Pgmname = "LicCCCorrigeAprobPorIni" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12LegCuenAnio ;
   private short AV20aprobaciones ;
   private short AV13LegCuenDiasCorres ;
   private short GXv_int1[] ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2325LegCuLAprLicCnt ;
   private short AV14LegCuLAprLicCnt ;
   private short AV16nuevoConsumoIni ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2326LegCuLAprLicOri ;
   private String AV24Pgmname ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private boolean AV18corrigio ;
   private boolean AV19manualhay ;
   private boolean AV15iniHay ;
   private short[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02C52_A2266LegCuenAnio ;
   private String[] P02C52_A2243LegCuenLicTpo ;
   private int[] P02C52_A6LegNumero ;
   private short[] P02C52_A1EmpCod ;
   private int[] P02C52_A3CliCod ;
   private String[] P02C52_A2326LegCuLAprLicOri ;
   private short[] P02C52_A2325LegCuLAprLicCnt ;
   private java.util.Date[] P02C52_A2324LegCuLAprLicFch ;
   private String[] P02C53_A2326LegCuLAprLicOri ;
   private short[] P02C53_A2266LegCuenAnio ;
   private String[] P02C53_A2243LegCuenLicTpo ;
   private int[] P02C53_A6LegNumero ;
   private short[] P02C53_A1EmpCod ;
   private int[] P02C53_A3CliCod ;
   private java.util.Date[] P02C53_A2324LegCuLAprLicFch ;
}

final  class liccccorrigeaprobporini__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C52", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLAprLicOri, LegCuLAprLicCnt, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02C53", "SELECT LegCuLAprLicOri, LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ?) AND (LegCuLAprLicOri = ( 'inicializacion')) ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  LIMIT 1 FOR UPDATE OF legajo_cuenta_licenciasaprobaciones",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02C54", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
      }
   }

}

