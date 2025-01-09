package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_cabecera extends GXProcedure
{
   public ini_pais_cabecera( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_cabecera.class ), "" );
   }

   public ini_pais_cabecera( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             String aP1 )
   {
      ini_pais_cabecera.this.AV8PaiCod = aP0;
      ini_pais_cabecera.this.AV9PaiNom = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV13ConveInterDiasJor ;
      GXv_int2[0] = (byte)(0) ;
      GXv_int3[0] = AV15ConveMinMesesVac ;
      GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[0] = AV10sdt_conveVacaciones ;
      new web.defaultvacacionesconvenio(remoteHandle, context).execute( GXv_int1, GXv_int2, GXv_int3, GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4) ;
      ini_pais_cabecera.this.AV13ConveInterDiasJor = GXv_int1[0] ;
      ini_pais_cabecera.this.AV15ConveMinMesesVac = GXv_int3[0] ;
      AV10sdt_conveVacaciones = GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[0] ;
      /*
         INSERT RECORD ON TABLE Pais

      */
      A46PaiCod = AV8PaiCod ;
      A312PaiNom = AV9PaiNom ;
      A311PaiNacMostrar = true ;
      A310PaiDomMostrar = true ;
      A1252PaiReligDefault = "" ;
      n1252PaiReligDefault = false ;
      n1252PaiReligDefault = true ;
      A1271PaiMesHsPExt = DecimalUtil.doubleToDec(0) ;
      A1272PaiDiaHsPExt = "Promedio" ;
      A1405PaiMaxHorNor = DecimalUtil.doubleToDec(9) ;
      A1402PaiFondoCese = false ;
      GXv_int3[0] = AV16PaiPerVacDes ;
      GXv_int2[0] = AV17PaiPerVacHas ;
      GXv_decimal5[0] = AV18PaiFracVacAnt ;
      new web.defaultspervacaciones(remoteHandle, context).execute( AV8PaiCod, GXv_int3, GXv_int2, GXv_decimal5) ;
      ini_pais_cabecera.this.AV16PaiPerVacDes = GXv_int3[0] ;
      ini_pais_cabecera.this.AV17PaiPerVacHas = GXv_int2[0] ;
      ini_pais_cabecera.this.AV18PaiFracVacAnt = GXv_decimal5[0] ;
      A1521PaiPerVacDes = AV16PaiPerVacDes ;
      A1522PaiPerVacHas = AV17PaiPerVacHas ;
      A1814PaiFracVacAnt = AV18PaiFracVacAnt ;
      A1363PaiPromMeses = (byte)(6) ;
      A1590PaiPromMesTCnt = "meses" ;
      A1573PaiPromJorMeses = (byte)(0) ;
      A1591PaiPromJorMesTCnt = "dias" ;
      A1736PaiExcVizzoti = true ;
      A1737PaiVizzoti = DecimalUtil.stringToDec("0.6666") ;
      A1764PaiMinMesesVac = AV15ConveMinMesesVac ;
      A1765PaiInterDiasJor = AV13ConveInterDiasJor ;
      A1793PaiTipoExpDef = (byte)(2) ;
      A1625PaiGuarEdadMin = (byte)(0) ;
      A1626PaiGuarEdadMax = (byte)(0) ;
      /* Using cursor P01HS2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A312PaiNom, Boolean.valueOf(A311PaiNacMostrar), Boolean.valueOf(A310PaiDomMostrar), Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault, A1271PaiMesHsPExt, A1272PaiDiaHsPExt, Boolean.valueOf(A1402PaiFondoCese), A1405PaiMaxHorNor, Byte.valueOf(A1521PaiPerVacDes), Byte.valueOf(A1522PaiPerVacHas), Byte.valueOf(A1363PaiPromMeses), Byte.valueOf(A1573PaiPromJorMeses), A1590PaiPromMesTCnt, A1591PaiPromJorMesTCnt, Byte.valueOf(A1625PaiGuarEdadMin), Byte.valueOf(A1626PaiGuarEdadMax), Boolean.valueOf(A1736PaiExcVizzoti), A1737PaiVizzoti, Byte.valueOf(A1764PaiMinMesesVac), Short.valueOf(A1765PaiInterDiasJor), Byte.valueOf(A1793PaiTipoExpDef), A1814PaiFracVacAnt});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
      AV21GXV1 = 1 ;
      while ( AV21GXV1 <= AV10sdt_conveVacaciones.size() )
      {
         AV11itemConveVac = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)((web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)AV10sdt_conveVacaciones.elementAt(-1+AV21GXV1));
         /*
            INSERT RECORD ON TABLE PaisVacaciones

         */
         A46PaiCod = AV8PaiCod ;
         A1766PaiVacDesAnt = AV11itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti() ;
         A1767PaiVacHasAnt = AV11itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti() ;
         A1768PaiVacDias = AV11itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias() ;
         /* Using cursor P01HS3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt), Byte.valueOf(A1767PaiVacHasAnt), Byte.valueOf(A1768PaiVacDias)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
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
         AV21GXV1 = (int)(AV21GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_cabecera");
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
      AV10sdt_conveVacaciones = new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>(web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem.class, "sdt_conveVacacionesItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4 = new GXBaseCollection[1] ;
      A312PaiNom = "" ;
      A1252PaiReligDefault = "" ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1272PaiDiaHsPExt = "" ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      GXv_int2 = new byte[1] ;
      AV18PaiFracVacAnt = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1590PaiPromMesTCnt = "" ;
      A1591PaiPromJorMesTCnt = "" ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      AV11itemConveVac = new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_cabecera__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15ConveMinMesesVac ;
   private byte AV16PaiPerVacDes ;
   private byte GXv_int3[] ;
   private byte AV17PaiPerVacHas ;
   private byte GXv_int2[] ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private byte A1363PaiPromMeses ;
   private byte A1573PaiPromJorMeses ;
   private byte A1764PaiMinMesesVac ;
   private byte A1793PaiTipoExpDef ;
   private byte A1625PaiGuarEdadMin ;
   private byte A1626PaiGuarEdadMax ;
   private byte A1766PaiVacDesAnt ;
   private byte A1767PaiVacHasAnt ;
   private byte A1768PaiVacDias ;
   private short AV8PaiCod ;
   private short AV13ConveInterDiasJor ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short A1765PaiInterDiasJor ;
   private short Gx_err ;
   private int GX_INS38 ;
   private int AV21GXV1 ;
   private int GX_INS240 ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal AV18PaiFracVacAnt ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private String A1252PaiReligDefault ;
   private String A1272PaiDiaHsPExt ;
   private String A1590PaiPromMesTCnt ;
   private String A1591PaiPromJorMesTCnt ;
   private String Gx_emsg ;
   private boolean A311PaiNacMostrar ;
   private boolean A310PaiDomMostrar ;
   private boolean n1252PaiReligDefault ;
   private boolean A1402PaiFondoCese ;
   private boolean A1736PaiExcVizzoti ;
   private String AV9PaiNom ;
   private String A312PaiNom ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> AV10sdt_conveVacaciones ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[] ;
   private web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem AV11itemConveVac ;
}

final  class ini_pais_cabecera__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HS2", "SAVEPOINT gxupdate;INSERT INTO Pais(PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiReligDefault, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiPromMeses, PaiPromJorMeses, PaiPromMesTCnt, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiFracVacAnt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HS3", "SAVEPOINT gxupdate;INSERT INTO PaisVacaciones(PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 20);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 1);
               stmt.setString(7, (String)parms[7], 20);
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setByte(10, ((Number) parms[10]).byteValue());
               stmt.setByte(11, ((Number) parms[11]).byteValue());
               stmt.setByte(12, ((Number) parms[12]).byteValue());
               stmt.setByte(13, ((Number) parms[13]).byteValue());
               stmt.setString(14, (String)parms[14], 20);
               stmt.setString(15, (String)parms[15], 20);
               stmt.setByte(16, ((Number) parms[16]).byteValue());
               stmt.setByte(17, ((Number) parms[17]).byteValue());
               stmt.setBoolean(18, ((Boolean) parms[18]).booleanValue());
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 4);
               stmt.setByte(20, ((Number) parms[20]).byteValue());
               stmt.setShort(21, ((Number) parms[21]).shortValue());
               stmt.setByte(22, ((Number) parms[22]).byteValue());
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[23], 4);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
      }
   }

}

