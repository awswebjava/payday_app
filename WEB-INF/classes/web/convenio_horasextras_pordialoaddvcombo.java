package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_horasextras_pordialoaddvcombo extends GXProcedure
{
   public convenio_horasextras_pordialoaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_horasextras_pordialoaddvcombo.class ), "" );
   }

   public convenio_horasextras_pordialoaddvcombo( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             short aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      convenio_horasextras_pordialoaddvcombo.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        short aP6 ,
                        int aP7 ,
                        short aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             short aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      convenio_horasextras_pordialoaddvcombo.this.AV15ComboName = aP0;
      convenio_horasextras_pordialoaddvcombo.this.AV16TrnMode = aP1;
      convenio_horasextras_pordialoaddvcombo.this.AV17IsDynamicCall = aP2;
      convenio_horasextras_pordialoaddvcombo.this.AV18CliCod = aP3;
      convenio_horasextras_pordialoaddvcombo.this.AV19CliPaiConve = aP4;
      convenio_horasextras_pordialoaddvcombo.this.AV20CliConvenio = aP5;
      convenio_horasextras_pordialoaddvcombo.this.AV21ConveHsExSec = aP6;
      convenio_horasextras_pordialoaddvcombo.this.AV32Cond_CliCod = aP7;
      convenio_horasextras_pordialoaddvcombo.this.AV33Cond_CliPaiConve = aP8;
      convenio_horasextras_pordialoaddvcombo.this.AV34Cond_CliConvenio = aP9;
      convenio_horasextras_pordialoaddvcombo.this.AV12SearchTxt = aP10;
      convenio_horasextras_pordialoaddvcombo.this.aP11 = aP11;
      convenio_horasextras_pordialoaddvcombo.this.aP12 = aP12;
      convenio_horasextras_pordialoaddvcombo.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia", GXv_boolean2) ;
      convenio_horasextras_pordialoaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "ConvHsPDiaTipTra") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONVHSPDIATIPTRA' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_CONVHSPDIATIPTRA' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1323ConveHsDia ,
                                              Integer.valueOf(AV32Cond_CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              Short.valueOf(AV33Cond_CliPaiConve) ,
                                              A1565CliConvenio ,
                                              AV34Cond_CliConvenio } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01HD2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV32Cond_CliCod), Short.valueOf(AV33Cond_CliPaiConve), AV34Cond_CliConvenio, lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P01HD2_A3CliCod[0] ;
            A1564CliPaiConve = P01HD2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01HD2_A1565CliConvenio[0] ;
            A1323ConveHsDia = P01HD2_A1323ConveHsDia[0] ;
            A1294PaiTipoTraId = P01HD2_A1294PaiTipoTraId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1294PaiTipoTraId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( A1323ConveHsDia, "9.9")) );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV24Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01HD3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19CliPaiConve), AV20CliConvenio, Short.valueOf(AV21ConveHsExSec)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1327ConveHsExSec = P01HD3_A1327ConveHsExSec[0] ;
                  A1565CliConvenio = P01HD3_A1565CliConvenio[0] ;
                  A1564CliPaiConve = P01HD3_A1564CliPaiConve[0] ;
                  A3CliCod = P01HD3_A3CliCod[0] ;
                  A1326ConvHsPDiaTipTra = P01HD3_A1326ConvHsPDiaTipTra[0] ;
                  AV22SelectedValue = A1326ConvHsPDiaTipTra ;
                  AV29Cond_Aux_CliCod = A3CliCod ;
                  AV30Cond_Aux_CliPaiConve = A1564CliPaiConve ;
                  AV31Cond_Aux_CliConvenio = A1565CliConvenio ;
                  AV28PaiTipoTraId = A1326ConvHsPDiaTipTra ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV28PaiTipoTraId = AV12SearchTxt ;
               AV29Cond_Aux_CliCod = AV32Cond_CliCod ;
               AV30Cond_Aux_CliPaiConve = AV33Cond_CliPaiConve ;
               AV31Cond_Aux_CliConvenio = AV34Cond_CliConvenio ;
            }
            /* Using cursor P01HD4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV29Cond_Aux_CliCod), Short.valueOf(AV30Cond_Aux_CliPaiConve), AV31Cond_Aux_CliConvenio, AV28PaiTipoTraId});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1565CliConvenio = P01HD4_A1565CliConvenio[0] ;
               A1564CliPaiConve = P01HD4_A1564CliPaiConve[0] ;
               A3CliCod = P01HD4_A3CliCod[0] ;
               A1294PaiTipoTraId = P01HD4_A1294PaiTipoTraId[0] ;
               A1323ConveHsDia = P01HD4_A1323ConveHsDia[0] ;
               AV23SelectedText = GXutil.trim( localUtil.format( A1323ConveHsDia, "9.9")) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP11[0] = convenio_horasextras_pordialoaddvcombo.this.AV22SelectedValue;
      this.aP12[0] = convenio_horasextras_pordialoaddvcombo.this.AV23SelectedText;
      this.aP13[0] = convenio_horasextras_pordialoaddvcombo.this.AV24Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22SelectedValue = "" ;
      AV23SelectedText = "" ;
      AV24Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      P01HD2_A3CliCod = new int[1] ;
      P01HD2_A1564CliPaiConve = new short[1] ;
      P01HD2_A1565CliConvenio = new String[] {""} ;
      P01HD2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01HD2_A1294PaiTipoTraId = new String[] {""} ;
      A1294PaiTipoTraId = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01HD3_A1327ConveHsExSec = new short[1] ;
      P01HD3_A1565CliConvenio = new String[] {""} ;
      P01HD3_A1564CliPaiConve = new short[1] ;
      P01HD3_A3CliCod = new int[1] ;
      P01HD3_A1326ConvHsPDiaTipTra = new String[] {""} ;
      A1326ConvHsPDiaTipTra = "" ;
      AV31Cond_Aux_CliConvenio = "" ;
      AV28PaiTipoTraId = "" ;
      P01HD4_A1565CliConvenio = new String[] {""} ;
      P01HD4_A1564CliPaiConve = new short[1] ;
      P01HD4_A3CliCod = new int[1] ;
      P01HD4_A1294PaiTipoTraId = new String[] {""} ;
      P01HD4_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_horasextras_pordialoaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01HD2_A3CliCod, P01HD2_A1564CliPaiConve, P01HD2_A1565CliConvenio, P01HD2_A1323ConveHsDia, P01HD2_A1294PaiTipoTraId
            }
            , new Object[] {
            P01HD3_A1327ConveHsExSec, P01HD3_A1565CliConvenio, P01HD3_A1564CliPaiConve, P01HD3_A3CliCod, P01HD3_A1326ConvHsPDiaTipTra
            }
            , new Object[] {
            P01HD4_A1565CliConvenio, P01HD4_A1564CliPaiConve, P01HD4_A3CliCod, P01HD4_A1294PaiTipoTraId, P01HD4_A1323ConveHsDia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19CliPaiConve ;
   private short AV21ConveHsExSec ;
   private short AV33Cond_CliPaiConve ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short AV30Cond_Aux_CliPaiConve ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV32Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int AV29Cond_Aux_CliCod ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV34Cond_CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1294PaiTipoTraId ;
   private String A1326ConvHsPDiaTipTra ;
   private String AV31Cond_Aux_CliConvenio ;
   private String AV28PaiTipoTraId ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV24Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV22SelectedValue ;
   private String AV23SelectedText ;
   private String lV12SearchTxt ;
   private String[] aP13 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private int[] P01HD2_A3CliCod ;
   private short[] P01HD2_A1564CliPaiConve ;
   private String[] P01HD2_A1565CliConvenio ;
   private java.math.BigDecimal[] P01HD2_A1323ConveHsDia ;
   private String[] P01HD2_A1294PaiTipoTraId ;
   private short[] P01HD3_A1327ConveHsExSec ;
   private String[] P01HD3_A1565CliConvenio ;
   private short[] P01HD3_A1564CliPaiConve ;
   private int[] P01HD3_A3CliCod ;
   private String[] P01HD3_A1326ConvHsPDiaTipTra ;
   private String[] P01HD4_A1565CliConvenio ;
   private short[] P01HD4_A1564CliPaiConve ;
   private int[] P01HD4_A3CliCod ;
   private String[] P01HD4_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] P01HD4_A1323ConveHsDia ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class convenio_horasextras_pordialoaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          int AV32Cond_CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV33Cond_CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String AV34Cond_CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsDia, PaiTipoTraId FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(SUBSTR(TO_CHAR(ConveHsDia,'0.9'), 2) like '%' || ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveHsDia" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01HD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (java.math.BigDecimal)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HD3", "SELECT ConveHsExSec, CliConvenio, CliPaiConve, CliCod, ConvHsPDiaTipTra FROM Convenio_horasextras_porDia WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveHsExSec = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HD4", "SELECT CliConvenio, CliPaiConve, CliCod, PaiTipoTraId, ConveHsDia FROM convenio_tiposdetrabajo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and PaiTipoTraId = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

