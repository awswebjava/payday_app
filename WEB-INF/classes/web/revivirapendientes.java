package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class revivirapendientes extends GXProcedure
{
   public revivirapendientes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( revivirapendientes.class ), "" );
   }

   public revivirapendientes( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            byte aP4 ,
                            boolean aP5 )
   {
      revivirapendientes.this.aP6 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        byte aP4 ,
                        boolean aP5 ,
                        short[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             byte aP4 ,
                             boolean aP5 ,
                             short[] aP6 )
   {
      revivirapendientes.this.AV11CliCod = aP0;
      revivirapendientes.this.AV10EmpCod = aP1;
      revivirapendientes.this.AV8LiqNro = aP2;
      revivirapendientes.this.AV9LegNumero = aP3;
      revivirapendientes.this.AV12LiqDCalculado = aP4;
      revivirapendientes.this.AV15omitirNovFija = aP5;
      revivirapendientes.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, "1") ;
      AV21GXLvl2 = (byte)(0) ;
      /* Using cursor P01EE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LiqNro), Integer.valueOf(AV9LegNumero), Byte.valueOf(AV12LiqDCalculado)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A507LiqDCalculado = P01EE2_A507LiqDCalculado[0] ;
         A6LegNumero = P01EE2_A6LegNumero[0] ;
         A31LiqNro = P01EE2_A31LiqNro[0] ;
         A1EmpCod = P01EE2_A1EmpCod[0] ;
         A3CliCod = P01EE2_A3CliCod[0] ;
         A394DConCodigo = P01EE2_A394DConCodigo[0] ;
         A1073LiqDNovedad = P01EE2_A1073LiqDNovedad[0] ;
         A504LiqDForOrig = P01EE2_A504LiqDForOrig[0] ;
         A274LiqDFormula = P01EE2_A274LiqDFormula[0] ;
         n274LiqDFormula = P01EE2_n274LiqDFormula[0] ;
         A508LiqDFormulaHTML = P01EE2_A508LiqDFormulaHTML[0] ;
         n508LiqDFormulaHTML = P01EE2_n508LiqDFormulaHTML[0] ;
         A749LiqDFormuAux = P01EE2_A749LiqDFormuAux[0] ;
         n749LiqDFormuAux = P01EE2_n749LiqDFormuAux[0] ;
         A81LiqDSecuencial = P01EE2_A81LiqDSecuencial[0] ;
         AV21GXLvl2 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, "2 "+A394DConCodigo) ;
         AV17revivio = false ;
         if ( ! AV15omitirNovFija )
         {
            A507LiqDCalculado = (byte)(0) ;
            AV17revivio = true ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, "3 "+GXutil.trim( GXutil.booltostr( A1073LiqDNovedad))) ;
            if ( ! A1073LiqDNovedad )
            {
               A507LiqDCalculado = (byte)(0) ;
               AV17revivio = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, httpContext.getMessage( "3b", "")) ;
            }
            else
            {
               GXv_decimal1[0] = AV16AgeImporte ;
               new web.getageimportedeliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A394DConCodigo, A31LiqNro, GXv_decimal1) ;
               revivirapendientes.this.AV16AgeImporte = GXv_decimal1[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, "4 "+GXutil.trim( GXutil.str( AV16AgeImporte, 14, 2))) ;
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeImporte)==0) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, "5") ;
                  A507LiqDCalculado = (byte)(0) ;
                  AV17revivio = true ;
               }
            }
         }
         if ( ( AV17revivio ) && ( AV15omitirNovFija ) )
         {
            A274LiqDFormula = GXutil.trim( A504LiqDForOrig) ;
            n274LiqDFormula = false ;
            A508LiqDFormulaHTML = GXutil.trim( A504LiqDForOrig) ;
            n508LiqDFormulaHTML = false ;
            A749LiqDFormuAux = GXutil.trim( A504LiqDForOrig) ;
            n749LiqDFormuAux = false ;
         }
         AV14cantRev = (short)(AV14cantRev+1) ;
         /* Using cursor P01EE3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A507LiqDCalculado), Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV21GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV20Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = revivirapendientes.this.AV14cantRev;
      Application.commitDataStores(context, remoteHandle, pr_default, "revivirapendientes");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      P01EE2_A507LiqDCalculado = new byte[1] ;
      P01EE2_A6LegNumero = new int[1] ;
      P01EE2_A31LiqNro = new int[1] ;
      P01EE2_A1EmpCod = new short[1] ;
      P01EE2_A3CliCod = new int[1] ;
      P01EE2_A394DConCodigo = new String[] {""} ;
      P01EE2_A1073LiqDNovedad = new boolean[] {false} ;
      P01EE2_A504LiqDForOrig = new String[] {""} ;
      P01EE2_A274LiqDFormula = new String[] {""} ;
      P01EE2_n274LiqDFormula = new boolean[] {false} ;
      P01EE2_A508LiqDFormulaHTML = new String[] {""} ;
      P01EE2_n508LiqDFormulaHTML = new boolean[] {false} ;
      P01EE2_A749LiqDFormuAux = new String[] {""} ;
      P01EE2_n749LiqDFormuAux = new boolean[] {false} ;
      P01EE2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A504LiqDForOrig = "" ;
      A274LiqDFormula = "" ;
      A508LiqDFormulaHTML = "" ;
      A749LiqDFormuAux = "" ;
      AV16AgeImporte = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.revivirapendientes__default(),
         new Object[] {
             new Object[] {
            P01EE2_A507LiqDCalculado, P01EE2_A6LegNumero, P01EE2_A31LiqNro, P01EE2_A1EmpCod, P01EE2_A3CliCod, P01EE2_A394DConCodigo, P01EE2_A1073LiqDNovedad, P01EE2_A504LiqDForOrig, P01EE2_A274LiqDFormula, P01EE2_n274LiqDFormula,
            P01EE2_A508LiqDFormulaHTML, P01EE2_n508LiqDFormulaHTML, P01EE2_A749LiqDFormuAux, P01EE2_n749LiqDFormuAux, P01EE2_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      AV20Pgmname = "revivirAPendientes" ;
      /* GeneXus formulas. */
      AV20Pgmname = "revivirAPendientes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqDCalculado ;
   private byte AV21GXLvl2 ;
   private byte A507LiqDCalculado ;
   private short AV10EmpCod ;
   private short AV14cantRev ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV16AgeImporte ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV15omitirNovFija ;
   private boolean A1073LiqDNovedad ;
   private boolean n274LiqDFormula ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n749LiqDFormuAux ;
   private boolean AV17revivio ;
   private String A504LiqDForOrig ;
   private String A274LiqDFormula ;
   private String A508LiqDFormulaHTML ;
   private String A749LiqDFormuAux ;
   private short[] aP6 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01EE2_A507LiqDCalculado ;
   private int[] P01EE2_A6LegNumero ;
   private int[] P01EE2_A31LiqNro ;
   private short[] P01EE2_A1EmpCod ;
   private int[] P01EE2_A3CliCod ;
   private String[] P01EE2_A394DConCodigo ;
   private boolean[] P01EE2_A1073LiqDNovedad ;
   private String[] P01EE2_A504LiqDForOrig ;
   private String[] P01EE2_A274LiqDFormula ;
   private boolean[] P01EE2_n274LiqDFormula ;
   private String[] P01EE2_A508LiqDFormulaHTML ;
   private boolean[] P01EE2_n508LiqDFormulaHTML ;
   private String[] P01EE2_A749LiqDFormuAux ;
   private boolean[] P01EE2_n749LiqDFormuAux ;
   private int[] P01EE2_A81LiqDSecuencial ;
}

final  class revivirapendientes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EE2", "SELECT LiqDCalculado, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDNovedad, LiqDForOrig, LiqDFormula, LiqDFormulaHTML, LiqDFormuAux, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqDCalculado = ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01EE3", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDFormula=?, LiqDFormulaHTML=?, LiqDFormuAux=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(12);
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
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(2, (String)parms[2]);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[4]);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[6], 400);
               }
               stmt.setInt(5, ((Number) parms[7]).intValue());
               stmt.setShort(6, ((Number) parms[8]).shortValue());
               stmt.setInt(7, ((Number) parms[9]).intValue());
               stmt.setInt(8, ((Number) parms[10]).intValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               return;
      }
   }

}

