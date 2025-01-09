package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearerrornocalculado extends GXProcedure
{
   public setearerrornocalculado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearerrornocalculado.class ), "" );
   }

   public setearerrornocalculado( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              boolean aP4 )
   {
      setearerrornocalculado.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        boolean aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             boolean[] aP5 )
   {
      setearerrornocalculado.this.AV13CliCod = aP0;
      setearerrornocalculado.this.AV12EmpCod = aP1;
      setearerrornocalculado.this.AV11LiqNro = aP2;
      setearerrornocalculado.this.AV19parmLegNumero = aP3;
      setearerrornocalculado.this.AV20errorCiclicoEs = aP4;
      setearerrornocalculado.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00RK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV19parmLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00RK2_A6LegNumero[0] ;
         A31LiqNro = P00RK2_A31LiqNro[0] ;
         A1EmpCod = P00RK2_A1EmpCod[0] ;
         A3CliCod = P00RK2_A3CliCod[0] ;
         A891LiqLegError = P00RK2_A891LiqLegError[0] ;
         /* Using cursor P00RK3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            brkRK3 = false ;
            A507LiqDCalculado = P00RK3_A507LiqDCalculado[0] ;
            A270LiqDErrorDesc = P00RK3_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P00RK3_n270LiqDErrorDesc[0] ;
            A394DConCodigo = P00RK3_A394DConCodigo[0] ;
            A393DConDescrip = P00RK3_A393DConDescrip[0] ;
            A509LiqDOrdEjec = P00RK3_A509LiqDOrdEjec[0] ;
            A81LiqDSecuencial = P00RK3_A81LiqDSecuencial[0] ;
            while ( (pr_default.getStatus(1) != 101) && ( P00RK3_A3CliCod[0] == A3CliCod ) && ( P00RK3_A1EmpCod[0] == A1EmpCod ) && ( P00RK3_A31LiqNro[0] == A31LiqNro ) && ( P00RK3_A6LegNumero[0] == A6LegNumero ) )
            {
               if ( ! ( ( P00RK3_A507LiqDCalculado[0] == A507LiqDCalculado ) ) )
               {
                  if (true) break;
               }
               brkRK3 = false ;
               A270LiqDErrorDesc = P00RK3_A270LiqDErrorDesc[0] ;
               n270LiqDErrorDesc = P00RK3_n270LiqDErrorDesc[0] ;
               A394DConCodigo = P00RK3_A394DConCodigo[0] ;
               A393DConDescrip = P00RK3_A393DConDescrip[0] ;
               A509LiqDOrdEjec = P00RK3_A509LiqDOrdEjec[0] ;
               A81LiqDSecuencial = P00RK3_A81LiqDSecuencial[0] ;
               AV14LiqDErrorDesc = GXutil.trim( A270LiqDErrorDesc) ;
               AV9errorHay = true ;
               AV18DConCodigo = A394DConCodigo ;
               AV21DConDescrip = A393DConDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               brkRK3 = true ;
               pr_default.readNext(1);
            }
            if ( ! brkRK3 )
            {
               brkRK3 = true ;
               pr_default.readNext(1);
            }
         }
         pr_default.close(1);
         if ( AV9errorHay )
         {
            if ( AV20errorCiclicoEs )
            {
               GXt_char1 = AV15LiqLegError ;
               GXv_char2[0] = GXt_char1 ;
               new web.descripcionerrordependencia(remoteHandle, context).execute( AV13CliCod, GXv_char2) ;
               setearerrornocalculado.this.GXt_char1 = GXv_char2[0] ;
               AV15LiqLegError = GXt_char1 ;
               A891LiqLegError = GXutil.trim( AV15LiqLegError) + httpContext.getMessage( ". Concepto no resuelto: ", "") + GXutil.trim( AV21DConDescrip) ;
            }
            else
            {
               A891LiqLegError = httpContext.getMessage( "Concepto no calculado correctamente: ", "") + GXutil.trim( AV21DConDescrip) ;
            }
         }
         /* Using cursor P00RK4 */
         pr_default.execute(2, new Object[] {A891LiqLegError, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = setearerrornocalculado.this.AV9errorHay;
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
      P00RK2_A6LegNumero = new int[1] ;
      P00RK2_A31LiqNro = new int[1] ;
      P00RK2_A1EmpCod = new short[1] ;
      P00RK2_A3CliCod = new int[1] ;
      P00RK2_A891LiqLegError = new String[] {""} ;
      A891LiqLegError = "" ;
      P00RK3_A3CliCod = new int[1] ;
      P00RK3_A1EmpCod = new short[1] ;
      P00RK3_A31LiqNro = new int[1] ;
      P00RK3_A6LegNumero = new int[1] ;
      P00RK3_A507LiqDCalculado = new byte[1] ;
      P00RK3_A270LiqDErrorDesc = new String[] {""} ;
      P00RK3_n270LiqDErrorDesc = new boolean[] {false} ;
      P00RK3_A394DConCodigo = new String[] {""} ;
      P00RK3_A393DConDescrip = new String[] {""} ;
      P00RK3_A509LiqDOrdEjec = new long[1] ;
      P00RK3_A81LiqDSecuencial = new int[1] ;
      A270LiqDErrorDesc = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV14LiqDErrorDesc = "" ;
      AV18DConCodigo = "" ;
      AV21DConDescrip = "" ;
      AV15LiqLegError = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setearerrornocalculado__default(),
         new Object[] {
             new Object[] {
            P00RK2_A6LegNumero, P00RK2_A31LiqNro, P00RK2_A1EmpCod, P00RK2_A3CliCod, P00RK2_A891LiqLegError
            }
            , new Object[] {
            P00RK3_A3CliCod, P00RK3_A1EmpCod, P00RK3_A31LiqNro, P00RK3_A6LegNumero, P00RK3_A507LiqDCalculado, P00RK3_A270LiqDErrorDesc, P00RK3_n270LiqDErrorDesc, P00RK3_A394DConCodigo, P00RK3_A393DConDescrip, P00RK3_A509LiqDOrdEjec,
            P00RK3_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A507LiqDCalculado ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV19parmLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private long A509LiqDOrdEjec ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV18DConCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV20errorCiclicoEs ;
   private boolean AV9errorHay ;
   private boolean brkRK3 ;
   private boolean n270LiqDErrorDesc ;
   private String A891LiqLegError ;
   private String A270LiqDErrorDesc ;
   private String A393DConDescrip ;
   private String AV14LiqDErrorDesc ;
   private String AV21DConDescrip ;
   private String AV15LiqLegError ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00RK2_A6LegNumero ;
   private int[] P00RK2_A31LiqNro ;
   private short[] P00RK2_A1EmpCod ;
   private int[] P00RK2_A3CliCod ;
   private String[] P00RK2_A891LiqLegError ;
   private int[] P00RK3_A3CliCod ;
   private short[] P00RK3_A1EmpCod ;
   private int[] P00RK3_A31LiqNro ;
   private int[] P00RK3_A6LegNumero ;
   private byte[] P00RK3_A507LiqDCalculado ;
   private String[] P00RK3_A270LiqDErrorDesc ;
   private boolean[] P00RK3_n270LiqDErrorDesc ;
   private String[] P00RK3_A394DConCodigo ;
   private String[] P00RK3_A393DConDescrip ;
   private long[] P00RK3_A509LiqDOrdEjec ;
   private int[] P00RK3_A81LiqDSecuencial ;
}

final  class setearerrornocalculado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RK2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegError FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00RK3", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDCalculado, LiqDErrorDesc, DConCodigo, DConDescrip, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDCalculado = 0 ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDCalculado, LiqDOrdEjec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00RK4", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegError=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

