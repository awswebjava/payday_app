package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarfamiliarsiradig extends GXProcedure
{
   public actualizarfamiliarsiradig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarfamiliarsiradig.class ), "" );
   }

   public actualizarfamiliarsiradig( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        short aP6 ,
                        java.util.Date aP7 ,
                        java.math.BigDecimal aP8 ,
                        short aP9 ,
                        short aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             short aP6 ,
                             java.util.Date aP7 ,
                             java.math.BigDecimal aP8 ,
                             short aP9 ,
                             short aP10 )
   {
      actualizarfamiliarsiradig.this.AV9CliCod = aP0;
      actualizarfamiliarsiradig.this.AV8EmpCod = aP1;
      actualizarfamiliarsiradig.this.AV10LegNumero = aP2;
      actualizarfamiliarsiradig.this.AV11FamNroDoc = aP3;
      actualizarfamiliarsiradig.this.AV18FamApellido = aP4;
      actualizarfamiliarsiradig.this.AV17FamNombres = aP5;
      actualizarfamiliarsiradig.this.AV20parentesco = aP6;
      actualizarfamiliarsiradig.this.AV15FamFecNac = aP7;
      actualizarfamiliarsiradig.this.AV13FamTomaDeducImpGan = aP8;
      actualizarfamiliarsiradig.this.AV12FamMesDesde = aP9;
      actualizarfamiliarsiradig.this.AV21FamMesHasta = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14FamDiscap = false ;
      if ( AV20parentesco == 1 )
      {
         GXt_char1 = AV16ParCod ;
         GXv_char2[0] = GXt_char1 ;
         new web.parentescoconyuge(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
         actualizarfamiliarsiradig.this.GXt_char1 = GXv_char2[0] ;
         AV16ParCod = GXt_char1 ;
      }
      else
      {
         if ( ( AV20parentesco == 3 ) || ( AV20parentesco == 30 ) || ( AV20parentesco == 31 ) || ( AV20parentesco == 32 ) || ( AV20parentesco == 103 ) )
         {
            GXt_char1 = AV16ParCod ;
            GXv_char2[0] = GXt_char1 ;
            new web.parentescohijo(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
            actualizarfamiliarsiradig.this.GXt_char1 = GXv_char2[0] ;
            AV16ParCod = GXt_char1 ;
            if ( ( AV20parentesco == 31 ) || ( AV20parentesco == 32 ) )
            {
               AV14FamDiscap = true ;
            }
         }
      }
      if ( ! (GXutil.strcmp("", AV16ParCod)==0) )
      {
         AV24GXLvl26 = (byte)(0) ;
         /* Using cursor P00RY2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11FamNroDoc});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A750FamNroDoc = P00RY2_A750FamNroDoc[0] ;
            A6LegNumero = P00RY2_A6LegNumero[0] ;
            A1EmpCod = P00RY2_A1EmpCod[0] ;
            A3CliCod = P00RY2_A3CliCod[0] ;
            A220FamTomaDeducImpGan = P00RY2_A220FamTomaDeducImpGan[0] ;
            A751FamMesDesde = P00RY2_A751FamMesDesde[0] ;
            A752FamMesHasta = P00RY2_A752FamMesHasta[0] ;
            A29LegOrden = P00RY2_A29LegOrden[0] ;
            AV24GXLvl26 = (byte)(1) ;
            A220FamTomaDeducImpGan = AV13FamTomaDeducImpGan ;
            A751FamMesDesde = AV12FamMesDesde ;
            A752FamMesHasta = AV21FamMesHasta ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            /* Using cursor P00RY3 */
            pr_default.execute(1, new Object[] {A220FamTomaDeducImpGan, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
            if (true) break;
            /* Using cursor P00RY4 */
            pr_default.execute(2, new Object[] {A220FamTomaDeducImpGan, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV24GXLvl26 == 0 )
         {
            GXv_int3[0] = AV19LegOrden ;
            new web.obtnroordenlegfamilia(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, AV10LegNumero, GXv_int3) ;
            actualizarfamiliarsiradig.this.AV19LegOrden = GXv_int3[0] ;
            /*
               INSERT RECORD ON TABLE LegajoFamilia

            */
            A3CliCod = AV9CliCod ;
            A1EmpCod = AV8EmpCod ;
            A6LegNumero = AV10LegNumero ;
            A29LegOrden = AV19LegOrden ;
            A198FamApellido = AV18FamApellido ;
            A212FamNombres = AV17FamNombres ;
            A30ParCod = AV16ParCod ;
            A209FamFecNac = AV15FamFecNac ;
            n209FamFecNac = false ;
            A205FamDiscap = AV14FamDiscap ;
            n205FamDiscap = false ;
            A220FamTomaDeducImpGan = AV13FamTomaDeducImpGan ;
            A750FamNroDoc = AV11FamNroDoc ;
            A751FamMesDesde = AV12FamMesDesde ;
            A752FamMesHasta = AV21FamMesHasta ;
            A1547GuarCod = (short)(0) ;
            n1547GuarCod = false ;
            n1547GuarCod = true ;
            A199FamAsigFam = false ;
            A890FamAdherente = false ;
            A2090FamNomApe = "" ;
            /* Using cursor P00RY5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden), A198FamApellido, A212FamNombres, A30ParCod, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), Boolean.valueOf(A199FamAsigFam), A220FamTomaDeducImpGan, A750FamNroDoc, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Boolean.valueOf(A890FamAdherente), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod), A2090FamNomApe});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
            if ( (pr_default.getStatus(3) == 1) )
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
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarfamiliarsiradig");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16ParCod = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      P00RY2_A750FamNroDoc = new String[] {""} ;
      P00RY2_A6LegNumero = new int[1] ;
      P00RY2_A1EmpCod = new short[1] ;
      P00RY2_A3CliCod = new int[1] ;
      P00RY2_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00RY2_A751FamMesDesde = new short[1] ;
      P00RY2_A752FamMesHasta = new short[1] ;
      P00RY2_A29LegOrden = new short[1] ;
      A750FamNroDoc = "" ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      GXv_int3 = new short[1] ;
      A198FamApellido = "" ;
      A212FamNombres = "" ;
      A30ParCod = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      A2090FamNomApe = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarfamiliarsiradig__default(),
         new Object[] {
             new Object[] {
            P00RY2_A750FamNroDoc, P00RY2_A6LegNumero, P00RY2_A1EmpCod, P00RY2_A3CliCod, P00RY2_A220FamTomaDeducImpGan, P00RY2_A751FamMesDesde, P00RY2_A752FamMesHasta, P00RY2_A29LegOrden
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV24GXLvl26 ;
   private short AV8EmpCod ;
   private short AV20parentesco ;
   private short AV12FamMesDesde ;
   private short AV21FamMesHasta ;
   private short A1EmpCod ;
   private short A751FamMesDesde ;
   private short A752FamMesHasta ;
   private short A29LegOrden ;
   private short AV19LegOrden ;
   private short GXv_int3[] ;
   private short A1547GuarCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int GX_INS24 ;
   private java.math.BigDecimal AV13FamTomaDeducImpGan ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private String AV11FamNroDoc ;
   private String AV16ParCod ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A750FamNroDoc ;
   private String A30ParCod ;
   private String Gx_emsg ;
   private java.util.Date AV15FamFecNac ;
   private java.util.Date A209FamFecNac ;
   private boolean AV14FamDiscap ;
   private boolean n209FamFecNac ;
   private boolean A205FamDiscap ;
   private boolean n205FamDiscap ;
   private boolean n1547GuarCod ;
   private boolean A199FamAsigFam ;
   private boolean A890FamAdherente ;
   private String AV18FamApellido ;
   private String AV17FamNombres ;
   private String A198FamApellido ;
   private String A212FamNombres ;
   private String A2090FamNomApe ;
   private IDataStoreProvider pr_default ;
   private String[] P00RY2_A750FamNroDoc ;
   private int[] P00RY2_A6LegNumero ;
   private short[] P00RY2_A1EmpCod ;
   private int[] P00RY2_A3CliCod ;
   private java.math.BigDecimal[] P00RY2_A220FamTomaDeducImpGan ;
   private short[] P00RY2_A751FamMesDesde ;
   private short[] P00RY2_A752FamMesHasta ;
   private short[] P00RY2_A29LegOrden ;
}

final  class actualizarfamiliarsiradig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RY2", "SELECT FamNroDoc, LegNumero, EmpCod, CliCod, FamTomaDeducImpGan, FamMesDesde, FamMesHasta, LegOrden FROM LegajoFamilia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (FamNroDoc = ( ?)) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1 FOR UPDATE OF LegajoFamilia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00RY3", "SAVEPOINT gxupdate;UPDATE LegajoFamilia SET FamTomaDeducImpGan=?, FamMesDesde=?, FamMesHasta=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00RY4", "SAVEPOINT gxupdate;UPDATE LegajoFamilia SET FamTomaDeducImpGan=?, FamMesDesde=?, FamMesHasta=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00RY5", "SAVEPOINT gxupdate;INSERT INTO LegajoFamilia(CliCod, EmpCod, LegNumero, LegOrden, FamApellido, FamNombres, ParCod, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, GuarCod, FamNomApe) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setVarchar(6, (String)parms[5], 30, false);
               stmt.setString(7, (String)parms[6], 20);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.DATE );
               }
               else
               {
                  stmt.setDate(8, (java.util.Date)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(9, ((Boolean) parms[10]).booleanValue());
               }
               stmt.setBoolean(10, ((Boolean) parms[11]).booleanValue());
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[12], 4);
               stmt.setString(12, (String)parms[13], 20);
               stmt.setShort(13, ((Number) parms[14]).shortValue());
               stmt.setShort(14, ((Number) parms[15]).shortValue());
               stmt.setBoolean(15, ((Boolean) parms[16]).booleanValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(16, ((Number) parms[18]).shortValue());
               }
               stmt.setVarchar(17, (String)parms[19], 40, false);
               return;
      }
   }

}

