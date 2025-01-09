package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_embargo extends GXProcedure
{
   public ini_pais_embargo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_embargo.class ), "" );
   }

   public ini_pais_embargo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      ini_pais_embargo.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE embargabilidad

      */
      A1160EmbarPaiCod = AV8PaiCod ;
      A1162EmbargaDescrip = httpContext.getMessage( "Decreto 484/87", "") ;
      A1203EmbargaExplicacion = httpContext.getMessage( "Si el sueldo bruto (exceptuando al SAC) es menor o igual que 1 salario mínimo vital y movil, no se realiza embargo. Si es mayor a 1 smvm pero menor a 2 smvm se embarga el 10% del excedente de 1 SMVM. Si es mayor a 2 SMVM se embarga el 20% del excedente de 1 SMVM. Para el embargo del SAC se usa la misma lógica pero comparando con el 50% del SMVM", "") ;
      /* Using cursor P01HU2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A1160EmbarPaiCod), A1162EmbargaDescrip, A1203EmbargaExplicacion});
      /* Retrieving last key number assigned */
      /* Using cursor P01HU3 */
      pr_default.execute(1);
      A1161EmbargaSec = P01HU3_A1161EmbargaSec[0] ;
      n1161EmbargaSec = P01HU3_n1161EmbargaSec[0] ;
      pr_default.close(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("embargabilidad");
      if ( (pr_default.getStatus(0) == 1) )
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
      AV9EmbargaSec = A1161EmbargaSec ;
      /*
         INSERT RECORD ON TABLE tipo_obligacion

      */
      A1164TipoOblCodigo = httpContext.getMessage( "cuota_alimentaria", "") ;
      A1165TipoOblDescrip = httpContext.getMessage( "Cuota alimentaria", "") ;
      A1159TipoOblPaiCod = AV8PaiCod ;
      A1168TipoOblTotTipo = (byte)(0) ;
      A1167TipoOblAnti = false ;
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      n1161EmbargaSec = true ;
      A1163TipoOblSec = (short)(0) ;
      A2346TipoOblSoloDescu = true ;
      /* Using cursor P01HU4 */
      pr_default.execute(2, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Short.valueOf(A1159TipoOblPaiCod), Boolean.valueOf(A1167TipoOblAnti), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu)});
      /* Retrieving last key number assigned */
      /* Using cursor P01HU5 */
      pr_default.execute(3);
      A1163TipoOblSec = P01HU5_A1163TipoOblSec[0] ;
      pr_default.close(3);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
      if ( (pr_default.getStatus(2) == 1) )
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
      /*
         INSERT RECORD ON TABLE tipo_obligacion

      */
      A1164TipoOblCodigo = httpContext.getMessage( "anticipo", "") ;
      A1165TipoOblDescrip = httpContext.getMessage( "Anticipo a pagar en cuotas", "") ;
      A1159TipoOblPaiCod = AV8PaiCod ;
      A1168TipoOblTotTipo = (byte)(2) ;
      A1167TipoOblAnti = true ;
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      n1161EmbargaSec = true ;
      A1163TipoOblSec = (short)(0) ;
      A2346TipoOblSoloDescu = true ;
      /* Using cursor P01HU6 */
      pr_default.execute(4, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Short.valueOf(A1159TipoOblPaiCod), Boolean.valueOf(A1167TipoOblAnti), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu)});
      /* Retrieving last key number assigned */
      /* Using cursor P01HU7 */
      pr_default.execute(5);
      A1163TipoOblSec = P01HU7_A1163TipoOblSec[0] ;
      pr_default.close(5);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
      if ( (pr_default.getStatus(4) == 1) )
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
      /*
         INSERT RECORD ON TABLE tipo_obligacion

      */
      A1164TipoOblCodigo = httpContext.getMessage( "embargo_comun", "") ;
      A1165TipoOblDescrip = httpContext.getMessage( "Embargo común", "") ;
      A1159TipoOblPaiCod = AV8PaiCod ;
      A1168TipoOblTotTipo = (byte)(1) ;
      A1167TipoOblAnti = false ;
      A1161EmbargaSec = AV9EmbargaSec ;
      n1161EmbargaSec = false ;
      A1163TipoOblSec = (short)(0) ;
      A2346TipoOblSoloDescu = true ;
      /* Using cursor P01HU8 */
      pr_default.execute(6, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Short.valueOf(A1159TipoOblPaiCod), Boolean.valueOf(A1167TipoOblAnti), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu)});
      /* Retrieving last key number assigned */
      /* Using cursor P01HU9 */
      pr_default.execute(7);
      A1163TipoOblSec = P01HU9_A1163TipoOblSec[0] ;
      pr_default.close(7);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
      if ( (pr_default.getStatus(6) == 1) )
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
      /*
         INSERT RECORD ON TABLE tipo_obligacion

      */
      A1164TipoOblCodigo = httpContext.getMessage( "otros", "") ;
      A1165TipoOblDescrip = httpContext.getMessage( "Otros", "") ;
      A1159TipoOblPaiCod = AV8PaiCod ;
      A1168TipoOblTotTipo = (byte)(1) ;
      A1167TipoOblAnti = false ;
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      n1161EmbargaSec = true ;
      A1163TipoOblSec = (short)(0) ;
      A2346TipoOblSoloDescu = false ;
      /* Using cursor P01HU10 */
      pr_default.execute(8, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Short.valueOf(A1159TipoOblPaiCod), Boolean.valueOf(A1167TipoOblAnti), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu)});
      /* Retrieving last key number assigned */
      /* Using cursor P01HU11 */
      pr_default.execute(9);
      A1163TipoOblSec = P01HU11_A1163TipoOblSec[0] ;
      pr_default.close(9);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
      if ( (pr_default.getStatus(8) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_embargo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1162EmbargaDescrip = "" ;
      A1203EmbargaExplicacion = "" ;
      scmdbuf = "" ;
      P01HU3_A1161EmbargaSec = new short[1] ;
      P01HU3_n1161EmbargaSec = new boolean[] {false} ;
      Gx_emsg = "" ;
      A1164TipoOblCodigo = "" ;
      A1165TipoOblDescrip = "" ;
      P01HU5_A1163TipoOblSec = new short[1] ;
      P01HU7_A1163TipoOblSec = new short[1] ;
      P01HU9_A1163TipoOblSec = new short[1] ;
      P01HU11_A1163TipoOblSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_embargo__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P01HU3_A1161EmbargaSec
            }
            , new Object[] {
            }
            , new Object[] {
            P01HU5_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            P01HU7_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            P01HU9_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            P01HU11_A1163TipoOblSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1168TipoOblTotTipo ;
   private short AV8PaiCod ;
   private short A1160EmbarPaiCod ;
   private short A1161EmbargaSec ;
   private short Gx_err ;
   private short AV9EmbargaSec ;
   private short A1159TipoOblPaiCod ;
   private short A1163TipoOblSec ;
   private int GX_INS132 ;
   private int GX_INS133 ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private String A1164TipoOblCodigo ;
   private boolean n1161EmbargaSec ;
   private boolean A1167TipoOblAnti ;
   private boolean A2346TipoOblSoloDescu ;
   private String A1203EmbargaExplicacion ;
   private String A1162EmbargaDescrip ;
   private String A1165TipoOblDescrip ;
   private IDataStoreProvider pr_default ;
   private short[] P01HU3_A1161EmbargaSec ;
   private boolean[] P01HU3_n1161EmbargaSec ;
   private short[] P01HU5_A1163TipoOblSec ;
   private short[] P01HU7_A1163TipoOblSec ;
   private short[] P01HU9_A1163TipoOblSec ;
   private short[] P01HU11_A1163TipoOblSec ;
}

final  class ini_pais_embargo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HU2", "SAVEPOINT gxupdate;INSERT INTO embargabilidad(EmbarPaiCod, EmbargaDescrip, EmbargaExplicacion) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HU3", "SELECT currval('EmbargaSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01HU4", "SAVEPOINT gxupdate;INSERT INTO tipo_obligacion(TipoOblCodigo, TipoOblDescrip, TipoOblPaiCod, TipoOblAnti, EmbargaSec, TipoOblTotTipo, TipoOblSoloDescu) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HU5", "SELECT currval('TipoOblSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01HU6", "SAVEPOINT gxupdate;INSERT INTO tipo_obligacion(TipoOblCodigo, TipoOblDescrip, TipoOblPaiCod, TipoOblAnti, EmbargaSec, TipoOblTotTipo, TipoOblSoloDescu) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HU7", "SELECT currval('TipoOblSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01HU8", "SAVEPOINT gxupdate;INSERT INTO tipo_obligacion(TipoOblCodigo, TipoOblDescrip, TipoOblPaiCod, TipoOblAnti, EmbargaSec, TipoOblTotTipo, TipoOblSoloDescu) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HU9", "SELECT currval('TipoOblSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01HU10", "SAVEPOINT gxupdate;INSERT INTO tipo_obligacion(TipoOblCodigo, TipoOblDescrip, TipoOblPaiCod, TipoOblAnti, EmbargaSec, TipoOblTotTipo, TipoOblSoloDescu) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HU11", "SELECT currval('TipoOblSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
      }
   }

}

