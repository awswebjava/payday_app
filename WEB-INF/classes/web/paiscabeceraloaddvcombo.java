package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paiscabeceraloaddvcombo extends GXProcedure
{
   public paiscabeceraloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paiscabeceraloaddvcombo.class ), "" );
   }

   public paiscabeceraloaddvcombo( int remoteHandle ,
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
      paiscabeceraloaddvcombo.this.aP7 = new String[] {""};
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
      paiscabeceraloaddvcombo.this.AV15ComboName = aP0;
      paiscabeceraloaddvcombo.this.AV16TrnMode = aP1;
      paiscabeceraloaddvcombo.this.AV17IsDynamicCall = aP2;
      paiscabeceraloaddvcombo.this.AV18PaiCod = aP3;
      paiscabeceraloaddvcombo.this.AV12SearchTxt = aP4;
      paiscabeceraloaddvcombo.this.aP5 = aP5;
      paiscabeceraloaddvcombo.this.aP6 = aP6;
      paiscabeceraloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisCabecera", GXv_boolean2) ;
      paiscabeceraloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "PaiReligDefault") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAIRELIGDEFAULT' */
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
      /* 'LOADCOMBOITEMS_PAIRELIGDEFAULT' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1283ReligNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01HY2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1283ReligNombre = P01HY2_A1283ReligNombre[0] ;
            A1229ReligId = P01HY2_A1229ReligId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1229ReligId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1283ReligNombre );
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
               /* Using cursor P01HY3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV18PaiCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A46PaiCod = P01HY3_A46PaiCod[0] ;
                  A1252PaiReligDefault = P01HY3_A1252PaiReligDefault[0] ;
                  n1252PaiReligDefault = P01HY3_n1252PaiReligDefault[0] ;
                  AV19SelectedValue = A1252PaiReligDefault ;
                  AV25ReligId = A1252PaiReligDefault ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV25ReligId = AV12SearchTxt ;
            }
            /* Using cursor P01HY4 */
            pr_default.execute(2, new Object[] {AV25ReligId});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1229ReligId = P01HY4_A1229ReligId[0] ;
               A1283ReligNombre = P01HY4_A1283ReligNombre[0] ;
               AV20SelectedText = A1283ReligNombre ;
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
      this.aP5[0] = paiscabeceraloaddvcombo.this.AV19SelectedValue;
      this.aP6[0] = paiscabeceraloaddvcombo.this.AV20SelectedText;
      this.aP7[0] = paiscabeceraloaddvcombo.this.AV21Combo_DataJson;
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
      A1283ReligNombre = "" ;
      P01HY2_A1283ReligNombre = new String[] {""} ;
      P01HY2_A1229ReligId = new String[] {""} ;
      A1229ReligId = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01HY3_A46PaiCod = new short[1] ;
      P01HY3_A1252PaiReligDefault = new String[] {""} ;
      P01HY3_n1252PaiReligDefault = new boolean[] {false} ;
      A1252PaiReligDefault = "" ;
      AV25ReligId = "" ;
      P01HY4_A1229ReligId = new String[] {""} ;
      P01HY4_A1283ReligNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paiscabeceraloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01HY2_A1283ReligNombre, P01HY2_A1229ReligId
            }
            , new Object[] {
            P01HY3_A46PaiCod, P01HY3_A1252PaiReligDefault, P01HY3_n1252PaiReligDefault
            }
            , new Object[] {
            P01HY4_A1229ReligId, P01HY4_A1283ReligNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private String A1229ReligId ;
   private String A1252PaiReligDefault ;
   private String AV25ReligId ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n1252PaiReligDefault ;
   private String AV21Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV19SelectedValue ;
   private String AV20SelectedText ;
   private String lV12SearchTxt ;
   private String A1283ReligNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HY2_A1283ReligNombre ;
   private String[] P01HY2_A1229ReligId ;
   private short[] P01HY3_A46PaiCod ;
   private String[] P01HY3_A1252PaiReligDefault ;
   private boolean[] P01HY3_n1252PaiReligDefault ;
   private String[] P01HY4_A1229ReligId ;
   private String[] P01HY4_A1283ReligNombre ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class paiscabeceraloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1283ReligNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ReligNombre, ReligId FROM Religion" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ReligNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ReligNombre" ;
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
                  return conditional_P01HY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HY3", "SELECT PaiCod, PaiReligDefault FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HY4", "SELECT ReligId, ReligNombre FROM Religion WHERE ReligId = ( ?) ORDER BY ReligId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

