package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newlegcclicconsumos extends GXProcedure
{
   public newlegcclicconsumos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newlegcclicconsumos.class ), "" );
   }

   public newlegcclicconsumos( int remoteHandle ,
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
                            short aP5 ,
                            short aP6 ,
                            String aP7 ,
                            int aP8 )
   {
      newlegcclicconsumos.this.aP9 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short aP5 ,
                        short aP6 ,
                        String aP7 ,
                        int aP8 ,
                        short[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String aP7 ,
                             int aP8 ,
                             short[] aP9 )
   {
      newlegcclicconsumos.this.AV8CliCod = aP0;
      newlegcclicconsumos.this.AV13EmpCod = aP1;
      newlegcclicconsumos.this.AV9LegNumero = aP2;
      newlegcclicconsumos.this.AV10LegCuenLicTpo = aP3;
      newlegcclicconsumos.this.AV14LegCuenAnio = aP4;
      newlegcclicconsumos.this.AV11LegCuLConsAnio = aP5;
      newlegcclicconsumos.this.AV15LegCuLConsCnt = aP6;
      newlegcclicconsumos.this.AV16LegCuLConsOri = aP7;
      newlegcclicconsumos.this.AV19LegCulConsLiqNro = aP8;
      newlegcclicconsumos.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV9LegNumero), AV10LegCuenLicTpo, Short.valueOf(AV14LegCuenAnio), Short.valueOf(AV11LegCuLConsAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02BO2_A3CliCod[0] ;
         A1EmpCod = P02BO2_A1EmpCod[0] ;
         A6LegNumero = P02BO2_A6LegNumero[0] ;
         A2243LegCuenLicTpo = P02BO2_A2243LegCuenLicTpo[0] ;
         A2266LegCuenAnio = P02BO2_A2266LegCuenAnio[0] ;
         A2310LegCuLConsAnio = P02BO2_A2310LegCuLConsAnio[0] ;
         A2327LegCuLConsOri = P02BO2_A2327LegCuLConsOri[0] ;
         A2311LegCuLConsSec = P02BO2_A2311LegCuLConsSec[0] ;
         if ( (0==AV12LegCuLConsSec) )
         {
            AV12LegCuLConsSec = A2311LegCuLConsSec ;
         }
         if ( GXutil.strcmp(A2327LegCuLConsOri, "inicializacion") == 0 )
         {
            AV17iniHay = true ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ( GXutil.strcmp(AV16LegCuLConsOri, "inicializacion") != 0 ) || ! AV17iniHay )
      {
         AV12LegCuLConsSec = (short)(AV12LegCuLConsSec+1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV23Pgmname, httpContext.getMessage( "&LegCuLConsSec ", "")+GXutil.trim( GXutil.str( AV12LegCuLConsSec, 4, 0))+httpContext.getMessage( " &LegCuLConsCnt ", "")+GXutil.trim( GXutil.str( AV15LegCuLConsCnt, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV9LegNumero, 8, 0))) ;
         /*
            INSERT RECORD ON TABLE legajo_cuenta_licenciasconsumos

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV13EmpCod ;
         A6LegNumero = AV9LegNumero ;
         A2243LegCuenLicTpo = AV10LegCuenLicTpo ;
         A2266LegCuenAnio = AV14LegCuenAnio ;
         A2310LegCuLConsAnio = AV11LegCuLConsAnio ;
         A2311LegCuLConsSec = AV12LegCuLConsSec ;
         A2312LegCuLConsCnt = AV15LegCuLConsCnt ;
         A2327LegCuLConsOri = AV16LegCuLConsOri ;
         if ( ! (0==AV19LegCulConsLiqNro) )
         {
            A2342LegCulConsLiqNro = AV19LegCulConsLiqNro ;
            n2342LegCulConsLiqNro = false ;
         }
         else
         {
            A2342LegCulConsLiqNro = 0 ;
            n2342LegCulConsLiqNro = false ;
            n2342LegCulConsLiqNro = true ;
         }
         /* Using cursor P02BO3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec), Short.valueOf(A2312LegCuLConsCnt), A2327LegCuLConsOri, Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         GXv_int1[0] = AV18corrigiocant ;
         new web.liccccorrigeconsumosporini(remoteHandle, context).execute( AV8CliCod, AV13EmpCod, AV9LegNumero, AV10LegCuenLicTpo, AV14LegCuenAnio, GXv_int1) ;
         newlegcclicconsumos.this.AV18corrigiocant = GXv_int1[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = newlegcclicconsumos.this.AV18corrigiocant;
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
      P02BO2_A3CliCod = new int[1] ;
      P02BO2_A1EmpCod = new short[1] ;
      P02BO2_A6LegNumero = new int[1] ;
      P02BO2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BO2_A2266LegCuenAnio = new short[1] ;
      P02BO2_A2310LegCuLConsAnio = new short[1] ;
      P02BO2_A2327LegCuLConsOri = new String[] {""} ;
      P02BO2_A2311LegCuLConsSec = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      A2327LegCuLConsOri = "" ;
      AV23Pgmname = "" ;
      Gx_emsg = "" ;
      GXv_int1 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newlegcclicconsumos__default(),
         new Object[] {
             new Object[] {
            P02BO2_A3CliCod, P02BO2_A1EmpCod, P02BO2_A6LegNumero, P02BO2_A2243LegCuenLicTpo, P02BO2_A2266LegCuenAnio, P02BO2_A2310LegCuLConsAnio, P02BO2_A2327LegCuLConsOri, P02BO2_A2311LegCuLConsSec
            }
            , new Object[] {
            }
         }
      );
      AV23Pgmname = "newLegCCLicConsumos" ;
      /* GeneXus formulas. */
      AV23Pgmname = "newLegCCLicConsumos" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV14LegCuenAnio ;
   private short AV11LegCuLConsAnio ;
   private short AV15LegCuLConsCnt ;
   private short AV18corrigiocant ;
   private short A1EmpCod ;
   private short A2266LegCuenAnio ;
   private short A2310LegCuLConsAnio ;
   private short A2311LegCuLConsSec ;
   private short AV12LegCuLConsSec ;
   private short A2312LegCuLConsCnt ;
   private short Gx_err ;
   private short GXv_int1[] ;
   private int AV8CliCod ;
   private int AV9LegNumero ;
   private int AV19LegCulConsLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int GX_INS289 ;
   private int A2342LegCulConsLiqNro ;
   private String AV10LegCuenLicTpo ;
   private String AV16LegCuLConsOri ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2327LegCuLConsOri ;
   private String AV23Pgmname ;
   private String Gx_emsg ;
   private boolean AV17iniHay ;
   private boolean n2342LegCulConsLiqNro ;
   private short[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P02BO2_A3CliCod ;
   private short[] P02BO2_A1EmpCod ;
   private int[] P02BO2_A6LegNumero ;
   private String[] P02BO2_A2243LegCuenLicTpo ;
   private short[] P02BO2_A2266LegCuenAnio ;
   private short[] P02BO2_A2310LegCuLConsAnio ;
   private String[] P02BO2_A2327LegCuLConsOri ;
   private short[] P02BO2_A2311LegCuLConsSec ;
}

final  class newlegcclicconsumos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BO2", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsOri, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? and LegCuLConsAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BO3", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licenciasconsumos(CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec, LegCuLConsCnt, LegCuLConsOri, LegCulConsLiqNro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               return;
      }
   }

}

