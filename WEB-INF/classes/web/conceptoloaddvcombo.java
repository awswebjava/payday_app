package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoloaddvcombo extends GXProcedure
{
   public conceptoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoloaddvcombo.class ), "" );
   }

   public conceptoloaddvcombo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      conceptoloaddvcombo.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      conceptoloaddvcombo.this.AV15ComboName = aP0;
      conceptoloaddvcombo.this.AV16TrnMode = aP1;
      conceptoloaddvcombo.this.AV17IsDynamicCall = aP2;
      conceptoloaddvcombo.this.AV18CliCod = aP3;
      conceptoloaddvcombo.this.AV19ConCodigo = aP4;
      conceptoloaddvcombo.this.AV29Cond_CliCod = aP5;
      conceptoloaddvcombo.this.AV12SearchTxt = aP6;
      conceptoloaddvcombo.this.aP7 = aP7;
      conceptoloaddvcombo.this.aP8 = aP8;
      conceptoloaddvcombo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto", GXv_boolean2) ;
      conceptoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "MegCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MEGCODIGO' */
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
      /* 'LOADCOMBOITEMS_MEGCODIGO' Routine */
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
               AV30MegCodigo_Filter = AV28ValueItem ;
               AV35GXLvl32 = (byte)(0) ;
               /* Using cursor P01F42 */
               pr_default.execute(0, new Object[] {Integer.valueOf(AV29Cond_CliCod), AV30MegCodigo_Filter});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A3CliCod = P01F42_A3CliCod[0] ;
                  A11MegCodigo = P01F42_A11MegCodigo[0] ;
                  A300MegDescrip = P01F42_A300MegDescrip[0] ;
                  AV35GXLvl32 = (byte)(1) ;
                  AV26DscsCollection.add(A300MegDescrip, 0);
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
                                                 A300MegDescrip ,
                                                 Integer.valueOf(AV29Cond_CliCod) ,
                                                 Integer.valueOf(A3CliCod) } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01F43 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV29Cond_CliCod), lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A300MegDescrip = P01F43_A300MegDescrip[0] ;
               A3CliCod = P01F43_A3CliCod[0] ;
               A11MegCodigo = P01F43_A11MegCodigo[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A11MegCodigo );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A300MegDescrip );
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
      this.aP7[0] = conceptoloaddvcombo.this.AV20SelectedValue;
      this.aP8[0] = conceptoloaddvcombo.this.AV21SelectedText;
      this.aP9[0] = conceptoloaddvcombo.this.AV22Combo_DataJson;
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
      A300MegDescrip = "" ;
      AV27ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28ValueItem = "" ;
      AV30MegCodigo_Filter = "" ;
      scmdbuf = "" ;
      P01F42_A3CliCod = new int[1] ;
      P01F42_A11MegCodigo = new String[] {""} ;
      P01F42_A300MegDescrip = new String[] {""} ;
      A11MegCodigo = "" ;
      lV12SearchTxt = "" ;
      P01F43_A300MegDescrip = new String[] {""} ;
      P01F43_A3CliCod = new int[1] ;
      P01F43_A11MegCodigo = new String[] {""} ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01F42_A3CliCod, P01F42_A11MegCodigo, P01F42_A300MegDescrip
            }
            , new Object[] {
            P01F43_A300MegDescrip, P01F43_A3CliCod, P01F43_A11MegCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV35GXLvl32 ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV29Cond_CliCod ;
   private int AV11MaxItems ;
   private int AV34GXV1 ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19ConCodigo ;
   private String AV30MegCodigo_Filter ;
   private String scmdbuf ;
   private String A11MegCodigo ;
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
   private String A300MegDescrip ;
   private String AV28ValueItem ;
   private String lV12SearchTxt ;
   private String[] aP9 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01F42_A3CliCod ;
   private String[] P01F42_A11MegCodigo ;
   private String[] P01F42_A300MegDescrip ;
   private String[] P01F43_A300MegDescrip ;
   private int[] P01F43_A3CliCod ;
   private String[] P01F43_A11MegCodigo ;
   private GXSimpleCollection<String> AV27ValuesCollection ;
   private GXSimpleCollection<String> AV26DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class conceptoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01F43( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A300MegDescrip ,
                                          int AV29Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT MegDescrip, CliCod, MegCodigo FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegDescrip" ;
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
                  return conditional_P01F43(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01F42", "SELECT CliCod, MegCodigo, MegDescrip FROM MotivoEgreso WHERE CliCod = ? and MegCodigo = ( ?) ORDER BY CliCod, MegCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01F43", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
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

