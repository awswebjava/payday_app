package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liccccorrigeconsumosporini extends GXProcedure
{
   public liccccorrigeconsumosporini( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liccccorrigeconsumosporini.class ), "" );
   }

   public liccccorrigeconsumosporini( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            short aP4 )
   {
      liccccorrigeconsumosporini.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short[] aP5 )
   {
      liccccorrigeconsumosporini.this.AV8CliCod = aP0;
      liccccorrigeconsumosporini.this.AV9EmpCod = aP1;
      liccccorrigeconsumosporini.this.AV10LegNumero = aP2;
      liccccorrigeconsumosporini.this.AV11LegCuenLicTpo = aP3;
      liccccorrigeconsumosporini.this.AV12LegCuenAnio = aP4;
      liccccorrigeconsumosporini.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV13LegCuenDiasCorres ;
      new web.licccgetcorresponden(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV11LegCuenLicTpo, AV12LegCuenAnio, GXv_int1) ;
      liccccorrigeconsumosporini.this.AV13LegCuenDiasCorres = GXv_int1[0] ;
      /* Using cursor P02BY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02BY2_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02BY2_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02BY2_A6LegNumero[0] ;
         A1EmpCod = P02BY2_A1EmpCod[0] ;
         A3CliCod = P02BY2_A3CliCod[0] ;
         A2327LegCuLConsOri = P02BY2_A2327LegCuLConsOri[0] ;
         A2312LegCuLConsCnt = P02BY2_A2312LegCuLConsCnt[0] ;
         A2310LegCuLConsAnio = P02BY2_A2310LegCuLConsAnio[0] ;
         A2311LegCuLConsSec = P02BY2_A2311LegCuLConsSec[0] ;
         if ( GXutil.strcmp(A2327LegCuLConsOri, "manual") != 0 )
         {
            AV17LegCuLConsCnt = (short)(AV17LegCuLConsCnt+A2312LegCuLConsCnt) ;
         }
         else
         {
            AV18manualHay = true ;
         }
         if ( GXutil.strcmp(A2327LegCuLConsOri, "inicializacion") == 0 )
         {
            AV15iniHay = true ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "&iniHay ", "")+GXutil.trim( GXutil.booltostr( AV15iniHay))+httpContext.getMessage( " &&LegCuLConsCnt ", "")+GXutil.trim( GXutil.str( AV17LegCuLConsCnt, 4, 0))+httpContext.getMessage( " &LegCuenDiasCorres ", "")+GXutil.trim( GXutil.str( AV13LegCuenDiasCorres, 4, 0))) ;
      if ( ! AV18manualHay && ( AV15iniHay ) && ( AV17LegCuLConsCnt > AV13LegCuenDiasCorres ) )
      {
         AV19corrigio = true ;
         AV16nuevoConsumoIni = (short)(AV17LegCuLConsCnt-AV13LegCuenDiasCorres) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "nuevoconsumo ", "")+GXutil.trim( GXutil.str( AV16nuevoConsumoIni, 4, 0))) ;
         /* Using cursor P02BY3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2327LegCuLConsOri = P02BY3_A2327LegCuLConsOri[0] ;
            A2266LegCuenAnio = P02BY3_A2266LegCuenAnio[0] ;
            A2243LegCuenLicTpo = P02BY3_A2243LegCuenLicTpo[0] ;
            A6LegNumero = P02BY3_A6LegNumero[0] ;
            A1EmpCod = P02BY3_A1EmpCod[0] ;
            A3CliCod = P02BY3_A3CliCod[0] ;
            A2312LegCuLConsCnt = P02BY3_A2312LegCuLConsCnt[0] ;
            A2310LegCuLConsAnio = P02BY3_A2310LegCuLConsAnio[0] ;
            A2311LegCuLConsSec = P02BY3_A2311LegCuLConsSec[0] ;
            AV20corrigiocant = A2312LegCuLConsCnt ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "ini", "")) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV24Pgmname, httpContext.getMessage( "dlt", "")) ;
            /* Using cursor P02BY4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
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
      this.aP5[0] = liccccorrigeconsumosporini.this.AV20corrigiocant;
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
      P02BY2_A2266LegCuenAnio = new short[1] ;
      P02BY2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BY2_A6LegNumero = new int[1] ;
      P02BY2_A1EmpCod = new short[1] ;
      P02BY2_A3CliCod = new int[1] ;
      P02BY2_A2327LegCuLConsOri = new String[] {""} ;
      P02BY2_A2312LegCuLConsCnt = new short[1] ;
      P02BY2_A2310LegCuLConsAnio = new short[1] ;
      P02BY2_A2311LegCuLConsSec = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      A2327LegCuLConsOri = "" ;
      AV24Pgmname = "" ;
      P02BY3_A2327LegCuLConsOri = new String[] {""} ;
      P02BY3_A2266LegCuenAnio = new short[1] ;
      P02BY3_A2243LegCuenLicTpo = new String[] {""} ;
      P02BY3_A6LegNumero = new int[1] ;
      P02BY3_A1EmpCod = new short[1] ;
      P02BY3_A3CliCod = new int[1] ;
      P02BY3_A2312LegCuLConsCnt = new short[1] ;
      P02BY3_A2310LegCuLConsAnio = new short[1] ;
      P02BY3_A2311LegCuLConsSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liccccorrigeconsumosporini__default(),
         new Object[] {
             new Object[] {
            P02BY2_A2266LegCuenAnio, P02BY2_A2243LegCuenLicTpo, P02BY2_A6LegNumero, P02BY2_A1EmpCod, P02BY2_A3CliCod, P02BY2_A2327LegCuLConsOri, P02BY2_A2312LegCuLConsCnt, P02BY2_A2310LegCuLConsAnio, P02BY2_A2311LegCuLConsSec
            }
            , new Object[] {
            P02BY3_A2327LegCuLConsOri, P02BY3_A2266LegCuenAnio, P02BY3_A2243LegCuenLicTpo, P02BY3_A6LegNumero, P02BY3_A1EmpCod, P02BY3_A3CliCod, P02BY3_A2312LegCuLConsCnt, P02BY3_A2310LegCuLConsAnio, P02BY3_A2311LegCuLConsSec
            }
            , new Object[] {
            }
         }
      );
      AV24Pgmname = "LicCCCorrigeConsumosPorIni" ;
      /* GeneXus formulas. */
      AV24Pgmname = "LicCCCorrigeConsumosPorIni" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12LegCuenAnio ;
   private short AV20corrigiocant ;
   private short AV13LegCuenDiasCorres ;
   private short GXv_int1[] ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2312LegCuLConsCnt ;
   private short A2310LegCuLConsAnio ;
   private short A2311LegCuLConsSec ;
   private short AV17LegCuLConsCnt ;
   private short AV16nuevoConsumoIni ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2327LegCuLConsOri ;
   private String AV24Pgmname ;
   private boolean AV18manualHay ;
   private boolean AV15iniHay ;
   private boolean AV19corrigio ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BY2_A2266LegCuenAnio ;
   private String[] P02BY2_A2243LegCuenLicTpo ;
   private int[] P02BY2_A6LegNumero ;
   private short[] P02BY2_A1EmpCod ;
   private int[] P02BY2_A3CliCod ;
   private String[] P02BY2_A2327LegCuLConsOri ;
   private short[] P02BY2_A2312LegCuLConsCnt ;
   private short[] P02BY2_A2310LegCuLConsAnio ;
   private short[] P02BY2_A2311LegCuLConsSec ;
   private String[] P02BY3_A2327LegCuLConsOri ;
   private short[] P02BY3_A2266LegCuenAnio ;
   private String[] P02BY3_A2243LegCuenLicTpo ;
   private int[] P02BY3_A6LegNumero ;
   private short[] P02BY3_A1EmpCod ;
   private int[] P02BY3_A3CliCod ;
   private short[] P02BY3_A2312LegCuLConsCnt ;
   private short[] P02BY3_A2310LegCuLConsAnio ;
   private short[] P02BY3_A2311LegCuLConsSec ;
}

final  class liccccorrigeconsumosporini__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BY2", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLConsOri, LegCuLConsCnt, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BY3", "SELECT LegCuLConsOri, LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLConsCnt, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ?) AND (LegCuLConsOri = ( 'inicializacion')) ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  LIMIT 1 FOR UPDATE OF legajo_cuenta_licenciasconsumos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02BY4", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
      }
   }

}

