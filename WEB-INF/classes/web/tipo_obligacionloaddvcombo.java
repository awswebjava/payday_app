package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_obligacionloaddvcombo extends GXProcedure
{
   public tipo_obligacionloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_obligacionloaddvcombo.class ), "" );
   }

   public tipo_obligacionloaddvcombo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      tipo_obligacionloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      tipo_obligacionloaddvcombo.this.AV15ComboName = aP0;
      tipo_obligacionloaddvcombo.this.AV16TrnMode = aP1;
      tipo_obligacionloaddvcombo.this.AV17IsDynamicCall = aP2;
      tipo_obligacionloaddvcombo.this.AV18TipoOblSec = aP3;
      tipo_obligacionloaddvcombo.this.AV12SearchTxt = aP4;
      tipo_obligacionloaddvcombo.this.aP5 = aP5;
      tipo_obligacionloaddvcombo.this.aP6 = aP6;
      tipo_obligacionloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion", GXv_boolean2) ;
      tipo_obligacionloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "TipoOblPaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_TIPOOBLPAICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmbargaSec") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMBARGASEC' */
            S121 ();
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
      /* 'LOADCOMBOITEMS_TIPOOBLPAICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A312PaiNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P019F2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A312PaiNom = P019F2_A312PaiNom[0] ;
            A46PaiCod = P019F2_A46PaiCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A46PaiCod, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A312PaiNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P019F3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV18TipoOblSec)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1163TipoOblSec = P019F3_A1163TipoOblSec[0] ;
                  A1159TipoOblPaiCod = P019F3_A1159TipoOblPaiCod[0] ;
                  AV19SelectedValue = ((0==A1159TipoOblPaiCod) ? "" : GXutil.trim( GXutil.str( A1159TipoOblPaiCod, 4, 0))) ;
                  AV25PaiCod = A1159TipoOblPaiCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV25PaiCod = (short)(GXutil.lval( AV12SearchTxt)) ;
            }
            /* Using cursor P019F4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV25PaiCod)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A46PaiCod = P019F4_A46PaiCod[0] ;
               A312PaiNom = P019F4_A312PaiNom[0] ;
               AV20SelectedText = A312PaiNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_EMBARGASEC' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1162EmbargaDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P019F5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1162EmbargaDescrip = P019F5_A1162EmbargaDescrip[0] ;
            A1161EmbargaSec = P019F5_A1161EmbargaSec[0] ;
            n1161EmbargaSec = P019F5_n1161EmbargaSec[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1161EmbargaSec, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1162EmbargaDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P019F6 */
               pr_default.execute(4, new Object[] {Short.valueOf(AV18TipoOblSec)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A1163TipoOblSec = P019F6_A1163TipoOblSec[0] ;
                  A1161EmbargaSec = P019F6_A1161EmbargaSec[0] ;
                  n1161EmbargaSec = P019F6_n1161EmbargaSec[0] ;
                  A1162EmbargaDescrip = P019F6_A1162EmbargaDescrip[0] ;
                  A1162EmbargaDescrip = P019F6_A1162EmbargaDescrip[0] ;
                  AV19SelectedValue = ((0==A1161EmbargaSec) ? "" : GXutil.trim( GXutil.str( A1161EmbargaSec, 4, 0))) ;
                  AV20SelectedText = A1162EmbargaDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV26EmbargaSec = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P019F7 */
               pr_default.execute(5, new Object[] {Short.valueOf(AV26EmbargaSec)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A1161EmbargaSec = P019F7_A1161EmbargaSec[0] ;
                  n1161EmbargaSec = P019F7_n1161EmbargaSec[0] ;
                  A1162EmbargaDescrip = P019F7_A1162EmbargaDescrip[0] ;
                  AV20SelectedText = A1162EmbargaDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = tipo_obligacionloaddvcombo.this.AV19SelectedValue;
      this.aP6[0] = tipo_obligacionloaddvcombo.this.AV20SelectedText;
      this.aP7[0] = tipo_obligacionloaddvcombo.this.AV21Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19SelectedValue = "" ;
      AV20SelectedText = "" ;
      AV21Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A312PaiNom = "" ;
      P019F2_A312PaiNom = new String[] {""} ;
      P019F2_A46PaiCod = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P019F3_A1163TipoOblSec = new short[1] ;
      P019F3_A1159TipoOblPaiCod = new short[1] ;
      P019F4_A46PaiCod = new short[1] ;
      P019F4_A312PaiNom = new String[] {""} ;
      A1162EmbargaDescrip = "" ;
      P019F5_A1162EmbargaDescrip = new String[] {""} ;
      P019F5_A1161EmbargaSec = new short[1] ;
      P019F5_n1161EmbargaSec = new boolean[] {false} ;
      P019F6_A1163TipoOblSec = new short[1] ;
      P019F6_A1161EmbargaSec = new short[1] ;
      P019F6_n1161EmbargaSec = new boolean[] {false} ;
      P019F6_A1162EmbargaDescrip = new String[] {""} ;
      P019F7_A1161EmbargaSec = new short[1] ;
      P019F7_n1161EmbargaSec = new boolean[] {false} ;
      P019F7_A1162EmbargaDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_obligacionloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P019F2_A312PaiNom, P019F2_A46PaiCod
            }
            , new Object[] {
            P019F3_A1163TipoOblSec, P019F3_A1159TipoOblPaiCod
            }
            , new Object[] {
            P019F4_A46PaiCod, P019F4_A312PaiNom
            }
            , new Object[] {
            P019F5_A1162EmbargaDescrip, P019F5_A1161EmbargaSec
            }
            , new Object[] {
            P019F6_A1163TipoOblSec, P019F6_A1161EmbargaSec, P019F6_n1161EmbargaSec, P019F6_A1162EmbargaDescrip
            }
            , new Object[] {
            P019F7_A1161EmbargaSec, P019F7_A1162EmbargaDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18TipoOblSec ;
   private short A46PaiCod ;
   private short A1163TipoOblSec ;
   private short A1159TipoOblPaiCod ;
   private short AV25PaiCod ;
   private short A1161EmbargaSec ;
   private short AV26EmbargaSec ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n1161EmbargaSec ;
   private String AV21Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV19SelectedValue ;
   private String AV20SelectedText ;
   private String lV12SearchTxt ;
   private String A312PaiNom ;
   private String A1162EmbargaDescrip ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P019F2_A312PaiNom ;
   private short[] P019F2_A46PaiCod ;
   private short[] P019F3_A1163TipoOblSec ;
   private short[] P019F3_A1159TipoOblPaiCod ;
   private short[] P019F4_A46PaiCod ;
   private String[] P019F4_A312PaiNom ;
   private String[] P019F5_A1162EmbargaDescrip ;
   private short[] P019F5_A1161EmbargaSec ;
   private boolean[] P019F5_n1161EmbargaSec ;
   private short[] P019F6_A1163TipoOblSec ;
   private short[] P019F6_A1161EmbargaSec ;
   private boolean[] P019F6_n1161EmbargaSec ;
   private String[] P019F6_A1162EmbargaDescrip ;
   private short[] P019F7_A1161EmbargaSec ;
   private boolean[] P019F7_n1161EmbargaSec ;
   private String[] P019F7_A1162EmbargaDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class tipo_obligacionloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P019F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A312PaiNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiNom, PaiCod FROM Pais" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiNom" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P019F5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1162EmbargaDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT EmbargaDescrip, EmbargaSec FROM embargabilidad" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmbargaDescrip" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P019F2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P019F5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019F3", "SELECT TipoOblSec, TipoOblPaiCod FROM tipo_obligacion WHERE TipoOblSec = ? ORDER BY TipoOblSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019F4", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019F5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019F6", "SELECT T1.TipoOblSec, T1.EmbargaSec, T2.EmbargaDescrip FROM (tipo_obligacion T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec) WHERE T1.TipoOblSec = ? ORDER BY T1.TipoOblSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019F7", "SELECT EmbargaSec, EmbargaDescrip FROM embargabilidad WHERE EmbargaSec = ? ORDER BY EmbargaSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

