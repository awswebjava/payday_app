package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenioloaddvcombo extends GXProcedure
{
   public convenioloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenioloaddvcombo.class ), "" );
   }

   public convenioloaddvcombo( int remoteHandle ,
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
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      convenioloaddvcombo.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      convenioloaddvcombo.this.AV15ComboName = aP0;
      convenioloaddvcombo.this.AV16TrnMode = aP1;
      convenioloaddvcombo.this.AV17IsDynamicCall = aP2;
      convenioloaddvcombo.this.AV18PaiCod = aP3;
      convenioloaddvcombo.this.AV19ConveCodigo = aP4;
      convenioloaddvcombo.this.AV12SearchTxt = aP5;
      convenioloaddvcombo.this.aP6 = aP6;
      convenioloaddvcombo.this.aP7 = aP7;
      convenioloaddvcombo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio", GXv_boolean2) ;
      convenioloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "propCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PROPCOD' */
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
      /* 'LOADCOMBOITEMS_PROPCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV27ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV26DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV34GXV1 = 1 ;
            while ( AV34GXV1 <= AV27ValuesCollection.size() )
            {
               AV28ValueItem = (String)AV27ValuesCollection.elementAt(-1+AV34GXV1) ;
               AV29propCod_Filter = AV28ValueItem ;
               AV35GXLvl32 = (byte)(0) ;
               /* Using cursor P024W2 */
               pr_default.execute(0, new Object[] {AV29propCod_Filter});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A2227propCod = P024W2_A2227propCod[0] ;
                  A2228propDesc = P024W2_A2228propDesc[0] ;
                  AV35GXLvl32 = (byte)(1) ;
                  AV26DscsCollection.add(A2228propDesc, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV35GXLvl32 == 0 )
               {
                  AV26DscsCollection.add("", 0);
               }
               AV34GXV1 = (int)(AV34GXV1+1) ;
            }
            AV22Combo_DataJson = AV26DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A2228propDesc } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P024W3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2228propDesc = P024W3_A2228propDesc[0] ;
               A2227propCod = P024W3_A2227propCod[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A2227propCod );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A2228propDesc );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = convenioloaddvcombo.this.AV20SelectedValue;
      this.aP7[0] = convenioloaddvcombo.this.AV21SelectedText;
      this.aP8[0] = convenioloaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV22Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      A2228propDesc = "" ;
      AV27ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28ValueItem = "" ;
      AV29propCod_Filter = "" ;
      scmdbuf = "" ;
      P024W2_A2227propCod = new String[] {""} ;
      P024W2_A2228propDesc = new String[] {""} ;
      A2227propCod = "" ;
      lV12SearchTxt = "" ;
      P024W3_A2228propDesc = new String[] {""} ;
      P024W3_A2227propCod = new String[] {""} ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenioloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P024W2_A2227propCod, P024W2_A2228propDesc
            }
            , new Object[] {
            P024W3_A2228propDesc, P024W3_A2227propCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV35GXLvl32 ;
   private short AV18PaiCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private int AV34GXV1 ;
   private String AV16TrnMode ;
   private String AV19ConveCodigo ;
   private String AV29propCod_Filter ;
   private String scmdbuf ;
   private String A2227propCod ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String A2228propDesc ;
   private String AV28ValueItem ;
   private String lV12SearchTxt ;
   private String[] aP8 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P024W2_A2227propCod ;
   private String[] P024W2_A2228propDesc ;
   private String[] P024W3_A2228propDesc ;
   private String[] P024W3_A2227propCod ;
   private GXSimpleCollection<String> AV27ValuesCollection ;
   private GXSimpleCollection<String> AV26DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class convenioloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P024W3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A2228propDesc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT propDesc, propCod FROM propiedades_adicionales" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(propDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY propDesc" ;
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
            case 1 :
                  return conditional_P024W3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P024W2", "SELECT propCod, propDesc FROM propiedades_adicionales WHERE propCod = ( ?) ORDER BY propCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P024W3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
      }
   }

}

