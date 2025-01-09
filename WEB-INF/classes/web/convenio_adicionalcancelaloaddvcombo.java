package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalcancelaloaddvcombo extends GXProcedure
{
   public convenio_adicionalcancelaloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalcancelaloaddvcombo.class ), "" );
   }

   public convenio_adicionalcancelaloaddvcombo( int remoteHandle ,
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
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      convenio_adicionalcancelaloaddvcombo.this.aP11 = new String[] {""};
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
                        String aP7 ,
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
                             String aP7 ,
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      convenio_adicionalcancelaloaddvcombo.this.AV15ComboName = aP0;
      convenio_adicionalcancelaloaddvcombo.this.AV16TrnMode = aP1;
      convenio_adicionalcancelaloaddvcombo.this.AV17IsDynamicCall = aP2;
      convenio_adicionalcancelaloaddvcombo.this.AV18CliCod = aP3;
      convenio_adicionalcancelaloaddvcombo.this.AV19CliPaiConve = aP4;
      convenio_adicionalcancelaloaddvcombo.this.AV20CliConvenio = aP5;
      convenio_adicionalcancelaloaddvcombo.this.AV21ConveAdicod = aP6;
      convenio_adicionalcancelaloaddvcombo.this.AV22ConveAdiSitCancela = aP7;
      convenio_adicionalcancelaloaddvcombo.this.AV12SearchTxt = aP8;
      convenio_adicionalcancelaloaddvcombo.this.aP9 = aP9;
      convenio_adicionalcancelaloaddvcombo.this.aP10 = aP10;
      convenio_adicionalcancelaloaddvcombo.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela", GXv_boolean2) ;
      convenio_adicionalcancelaloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A334SitDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01PV2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A334SitDescrip = P01PV2_A334SitDescrip[0] ;
            A16SitCodigo = P01PV2_A16SitCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A16SitCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A334SitDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV25Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01PV3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19CliPaiConve), AV20CliConvenio, AV21ConveAdicod, AV22ConveAdiSitCancela});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1824ConveAdiSitCancela = P01PV3_A1824ConveAdiSitCancela[0] ;
               A996ConveAdicod = P01PV3_A996ConveAdicod[0] ;
               A1565CliConvenio = P01PV3_A1565CliConvenio[0] ;
               A1564CliPaiConve = P01PV3_A1564CliPaiConve[0] ;
               A3CliCod = P01PV3_A3CliCod[0] ;
               AV23SelectedValue = A1824ConveAdiSitCancela ;
               AV29SitCodigo = A1824ConveAdiSitCancela ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            /* Using cursor P01PV4 */
            pr_default.execute(2, new Object[] {AV29SitCodigo});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A16SitCodigo = P01PV4_A16SitCodigo[0] ;
               A334SitDescrip = P01PV4_A334SitDescrip[0] ;
               AV24SelectedText = A334SitDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV22ConveAdiSitCancela)==0) )
            {
               AV23SelectedValue = AV22ConveAdiSitCancela ;
               /* Using cursor P01PV5 */
               pr_default.execute(3, new Object[] {AV22ConveAdiSitCancela});
               while ( (pr_default.getStatus(3) != 101) )
               {
                  A16SitCodigo = P01PV5_A16SitCodigo[0] ;
                  A334SitDescrip = P01PV5_A334SitDescrip[0] ;
                  AV24SelectedText = A334SitDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(3);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = convenio_adicionalcancelaloaddvcombo.this.AV23SelectedValue;
      this.aP10[0] = convenio_adicionalcancelaloaddvcombo.this.AV24SelectedText;
      this.aP11[0] = convenio_adicionalcancelaloaddvcombo.this.AV25Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23SelectedValue = "" ;
      AV24SelectedText = "" ;
      AV25Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A334SitDescrip = "" ;
      P01PV2_A334SitDescrip = new String[] {""} ;
      P01PV2_A16SitCodigo = new String[] {""} ;
      A16SitCodigo = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01PV3_A1824ConveAdiSitCancela = new String[] {""} ;
      P01PV3_A996ConveAdicod = new String[] {""} ;
      P01PV3_A1565CliConvenio = new String[] {""} ;
      P01PV3_A1564CliPaiConve = new short[1] ;
      P01PV3_A3CliCod = new int[1] ;
      A1824ConveAdiSitCancela = "" ;
      A996ConveAdicod = "" ;
      A1565CliConvenio = "" ;
      AV29SitCodigo = "" ;
      P01PV4_A16SitCodigo = new String[] {""} ;
      P01PV4_A334SitDescrip = new String[] {""} ;
      P01PV5_A16SitCodigo = new String[] {""} ;
      P01PV5_A334SitDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalcancelaloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01PV2_A334SitDescrip, P01PV2_A16SitCodigo
            }
            , new Object[] {
            P01PV3_A1824ConveAdiSitCancela, P01PV3_A996ConveAdicod, P01PV3_A1565CliConvenio, P01PV3_A1564CliPaiConve, P01PV3_A3CliCod
            }
            , new Object[] {
            P01PV4_A16SitCodigo, P01PV4_A334SitDescrip
            }
            , new Object[] {
            P01PV5_A16SitCodigo, P01PV5_A334SitDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV21ConveAdicod ;
   private String AV22ConveAdiSitCancela ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private String A1824ConveAdiSitCancela ;
   private String A996ConveAdicod ;
   private String A1565CliConvenio ;
   private String AV29SitCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV25Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV23SelectedValue ;
   private String AV24SelectedText ;
   private String lV12SearchTxt ;
   private String A334SitDescrip ;
   private String[] aP11 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P01PV2_A334SitDescrip ;
   private String[] P01PV2_A16SitCodigo ;
   private String[] P01PV3_A1824ConveAdiSitCancela ;
   private String[] P01PV3_A996ConveAdicod ;
   private String[] P01PV3_A1565CliConvenio ;
   private short[] P01PV3_A1564CliPaiConve ;
   private int[] P01PV3_A3CliCod ;
   private String[] P01PV4_A16SitCodigo ;
   private String[] P01PV4_A334SitDescrip ;
   private String[] P01PV5_A16SitCodigo ;
   private String[] P01PV5_A334SitDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class convenio_adicionalcancelaloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PV2( ModelContext context ,
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
            case 0 :
                  return conditional_P01PV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PV3", "SELECT ConveAdiSitCancela, ConveAdicod, CliConvenio, CliPaiConve, CliCod FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiSitCancela = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01PV4", "SELECT SitCodigo, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01PV5", "SELECT SitCodigo, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

