package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalloaddvcombo extends GXProcedure
{
   public convenio_adicionalloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalloaddvcombo.class ), "" );
   }

   public convenio_adicionalloaddvcombo( int remoteHandle ,
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
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      convenio_adicionalloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      convenio_adicionalloaddvcombo.this.AV15ComboName = aP0;
      convenio_adicionalloaddvcombo.this.AV16TrnMode = aP1;
      convenio_adicionalloaddvcombo.this.AV17IsDynamicCall = aP2;
      convenio_adicionalloaddvcombo.this.AV18CliCod = aP3;
      convenio_adicionalloaddvcombo.this.AV19CliPaiConve = aP4;
      convenio_adicionalloaddvcombo.this.AV20CliConvenio = aP5;
      convenio_adicionalloaddvcombo.this.AV21ConveAdicod = aP6;
      convenio_adicionalloaddvcombo.this.AV12SearchTxt = aP7;
      convenio_adicionalloaddvcombo.this.aP8 = aP8;
      convenio_adicionalloaddvcombo.this.aP9 = aP9;
      convenio_adicionalloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional", GXv_boolean2) ;
      convenio_adicionalloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "ConveAdiSitCancela") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONVEADISITCANCELA' */
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
      /* 'LOADCOMBOITEMS_CONVEADISITCANCELA' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV32ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV31DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV37GXV1 = 1 ;
            while ( AV37GXV1 <= AV32ValuesCollection.size() )
            {
               AV33ValueItem = (String)AV32ValuesCollection.elementAt(-1+AV37GXV1) ;
               AV34SitCodigo_Filter = AV33ValueItem ;
               AV38GXLvl32 = (byte)(0) ;
               /* Using cursor P01NV2 */
               pr_default.execute(0, new Object[] {AV34SitCodigo_Filter});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A16SitCodigo = P01NV2_A16SitCodigo[0] ;
                  A334SitDescrip = P01NV2_A334SitDescrip[0] ;
                  AV38GXLvl32 = (byte)(1) ;
                  AV31DscsCollection.add(A334SitDescrip, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV38GXLvl32 == 0 )
               {
                  AV31DscsCollection.add("", 0);
               }
               AV37GXV1 = (int)(AV37GXV1+1) ;
            }
            AV24Combo_DataJson = AV31DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A334SitDescrip } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01NV3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A334SitDescrip = P01NV3_A334SitDescrip[0] ;
               A16SitCodigo = P01NV3_A16SitCodigo[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A16SitCodigo );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A334SitDescrip );
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

   protected void cleanup( )
   {
      this.aP8[0] = convenio_adicionalloaddvcombo.this.AV22SelectedValue;
      this.aP9[0] = convenio_adicionalloaddvcombo.this.AV23SelectedText;
      this.aP10[0] = convenio_adicionalloaddvcombo.this.AV24Combo_DataJson;
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
      A334SitDescrip = "" ;
      AV32ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33ValueItem = "" ;
      AV34SitCodigo_Filter = "" ;
      scmdbuf = "" ;
      P01NV2_A16SitCodigo = new String[] {""} ;
      P01NV2_A334SitDescrip = new String[] {""} ;
      A16SitCodigo = "" ;
      lV12SearchTxt = "" ;
      P01NV3_A334SitDescrip = new String[] {""} ;
      P01NV3_A16SitCodigo = new String[] {""} ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01NV2_A16SitCodigo, P01NV2_A334SitDescrip
            }
            , new Object[] {
            P01NV3_A334SitDescrip, P01NV3_A16SitCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV38GXLvl32 ;
   private short AV19CliPaiConve ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int AV37GXV1 ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV21ConveAdicod ;
   private String AV34SitCodigo_Filter ;
   private String scmdbuf ;
   private String A16SitCodigo ;
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
   private String A334SitDescrip ;
   private String AV33ValueItem ;
   private String lV12SearchTxt ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NV2_A16SitCodigo ;
   private String[] P01NV2_A334SitDescrip ;
   private String[] P01NV3_A334SitDescrip ;
   private String[] P01NV3_A16SitCodigo ;
   private GXSimpleCollection<String> AV32ValuesCollection ;
   private GXSimpleCollection<String> AV31DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class convenio_adicionalloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01NV3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A334SitDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT SitDescrip, SitCodigo FROM Estado" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SitDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitDescrip" ;
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
                  return conditional_P01NV3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NV2", "SELECT SitCodigo, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01NV3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
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
               stmt.setString(1, (String)parms[0], 4);
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

