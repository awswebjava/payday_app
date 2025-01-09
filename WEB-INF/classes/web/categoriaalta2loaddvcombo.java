package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class categoriaalta2loaddvcombo extends GXProcedure
{
   public categoriaalta2loaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriaalta2loaddvcombo.class ), "" );
   }

   public categoriaalta2loaddvcombo( int remoteHandle ,
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
                             String aP6 ,
                             short aP7 ,
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      categoriaalta2loaddvcombo.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        short aP7 ,
                        String aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             short aP7 ,
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      categoriaalta2loaddvcombo.this.AV15ComboName = aP0;
      categoriaalta2loaddvcombo.this.AV16TrnMode = aP1;
      categoriaalta2loaddvcombo.this.AV17IsDynamicCall = aP2;
      categoriaalta2loaddvcombo.this.AV18CliCod = aP3;
      categoriaalta2loaddvcombo.this.AV19CliPaiConve = aP4;
      categoriaalta2loaddvcombo.this.AV20CliConvenio = aP5;
      categoriaalta2loaddvcombo.this.AV21CatCodigo = aP6;
      categoriaalta2loaddvcombo.this.AV32Cond_CatPaiCod = aP7;
      categoriaalta2loaddvcombo.this.AV12SearchTxt = aP8;
      categoriaalta2loaddvcombo.this.aP9 = aP9;
      categoriaalta2loaddvcombo.this.aP10 = aP10;
      categoriaalta2loaddvcombo.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2", GXv_boolean2) ;
      categoriaalta2loaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "CatPaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CATPAICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "CatProvCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CATPROVCOD' */
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
      /* 'LOADCOMBOITEMS_CATPAICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV29ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV28DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV37GXV1 = 1 ;
            while ( AV37GXV1 <= AV29ValuesCollection.size() )
            {
               AV30ValueItem = (String)AV29ValuesCollection.elementAt(-1+AV37GXV1) ;
               AV31PaiCod_Filter = (short)(GXutil.lval( AV30ValueItem)) ;
               AV38GXLvl34 = (byte)(0) ;
               /* Using cursor P024V2 */
               pr_default.execute(0, new Object[] {Short.valueOf(AV31PaiCod_Filter)});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A46PaiCod = P024V2_A46PaiCod[0] ;
                  A312PaiNom = P024V2_A312PaiNom[0] ;
                  AV38GXLvl34 = (byte)(1) ;
                  AV28DscsCollection.add(A312PaiNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV38GXLvl34 == 0 )
               {
                  AV28DscsCollection.add("", 0);
               }
               AV37GXV1 = (int)(AV37GXV1+1) ;
            }
            AV24Combo_DataJson = AV28DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A312PaiNom } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P024V3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A312PaiNom = P024V3_A312PaiNom[0] ;
               A46PaiCod = P024V3_A46PaiCod[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A46PaiCod, 4, 0)) );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A312PaiNom );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            AV24Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_CATPROVCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV29ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV28DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV40GXV2 = 1 ;
            while ( AV40GXV2 <= AV29ValuesCollection.size() )
            {
               AV30ValueItem = (String)AV29ValuesCollection.elementAt(-1+AV40GXV2) ;
               AV33ProvCod_Filter = (short)(GXutil.lval( AV30ValueItem)) ;
               AV41GXLvl73 = (byte)(0) ;
               /* Using cursor P024V4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV32Cond_CatPaiCod), Short.valueOf(AV33ProvCod_Filter)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A46PaiCod = P024V4_A46PaiCod[0] ;
                  A47ProvCod = P024V4_A47ProvCod[0] ;
                  A322ProvNom = P024V4_A322ProvNom[0] ;
                  AV41GXLvl73 = (byte)(1) ;
                  AV28DscsCollection.add(A322ProvNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
               if ( AV41GXLvl73 == 0 )
               {
                  AV28DscsCollection.add("", 0);
               }
               AV40GXV2 = (int)(AV40GXV2+1) ;
            }
            AV24Combo_DataJson = AV28DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(3, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A322ProvNom ,
                                                 Short.valueOf(A46PaiCod) ,
                                                 Short.valueOf(AV32Cond_CatPaiCod) } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P024V5 */
            pr_default.execute(3, new Object[] {Short.valueOf(AV32Cond_CatPaiCod), lV12SearchTxt});
            while ( (pr_default.getStatus(3) != 101) )
            {
               A46PaiCod = P024V5_A46PaiCod[0] ;
               A322ProvNom = P024V5_A322ProvNom[0] ;
               A47ProvCod = P024V5_A47ProvCod[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A47ProvCod, 4, 0)) );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A322ProvNom );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(3);
            }
            pr_default.close(3);
            AV24Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = categoriaalta2loaddvcombo.this.AV22SelectedValue;
      this.aP10[0] = categoriaalta2loaddvcombo.this.AV23SelectedText;
      this.aP11[0] = categoriaalta2loaddvcombo.this.AV24Combo_DataJson;
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
      A312PaiNom = "" ;
      AV29ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30ValueItem = "" ;
      scmdbuf = "" ;
      P024V2_A46PaiCod = new short[1] ;
      P024V2_A312PaiNom = new String[] {""} ;
      lV12SearchTxt = "" ;
      P024V3_A312PaiNom = new String[] {""} ;
      P024V3_A46PaiCod = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A322ProvNom = "" ;
      P024V4_A46PaiCod = new short[1] ;
      P024V4_A47ProvCod = new short[1] ;
      P024V4_A322ProvNom = new String[] {""} ;
      P024V5_A46PaiCod = new short[1] ;
      P024V5_A322ProvNom = new String[] {""} ;
      P024V5_A47ProvCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriaalta2loaddvcombo__default(),
         new Object[] {
             new Object[] {
            P024V2_A46PaiCod, P024V2_A312PaiNom
            }
            , new Object[] {
            P024V3_A312PaiNom, P024V3_A46PaiCod
            }
            , new Object[] {
            P024V4_A46PaiCod, P024V4_A47ProvCod, P024V4_A322ProvNom
            }
            , new Object[] {
            P024V5_A46PaiCod, P024V5_A322ProvNom, P024V5_A47ProvCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV38GXLvl34 ;
   private byte AV41GXLvl73 ;
   private short AV19CliPaiConve ;
   private short AV32Cond_CatPaiCod ;
   private short AV31PaiCod_Filter ;
   private short A46PaiCod ;
   private short AV33ProvCod_Filter ;
   private short A47ProvCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int AV37GXV1 ;
   private int AV40GXV2 ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV21CatCodigo ;
   private String scmdbuf ;
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
   private String A312PaiNom ;
   private String AV30ValueItem ;
   private String lV12SearchTxt ;
   private String A322ProvNom ;
   private String[] aP11 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private short[] P024V2_A46PaiCod ;
   private String[] P024V2_A312PaiNom ;
   private String[] P024V3_A312PaiNom ;
   private short[] P024V3_A46PaiCod ;
   private short[] P024V4_A46PaiCod ;
   private short[] P024V4_A47ProvCod ;
   private String[] P024V4_A322ProvNom ;
   private short[] P024V5_A46PaiCod ;
   private String[] P024V5_A322ProvNom ;
   private short[] P024V5_A47ProvCod ;
   private GXSimpleCollection<String> AV29ValuesCollection ;
   private GXSimpleCollection<String> AV28DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class categoriaalta2loaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P024V3( ModelContext context ,
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

   protected Object[] conditional_P024V5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A322ProvNom ,
                                          short A46PaiCod ,
                                          short AV32Cond_CatPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT PaiCod, ProvNom, ProvCod FROM Provincia" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ProvNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ProvNom" ;
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
            case 1 :
                  return conditional_P024V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P024V5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P024V2", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P024V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P024V4", "SELECT PaiCod, ProvCod, ProvNom FROM Provincia WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P024V5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
      }
   }

}

