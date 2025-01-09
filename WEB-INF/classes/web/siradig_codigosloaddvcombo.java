package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siradig_codigosloaddvcombo extends GXProcedure
{
   public siradig_codigosloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradig_codigosloaddvcombo.class ), "" );
   }

   public siradig_codigosloaddvcombo( int remoteHandle ,
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
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      siradig_codigosloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        int aP6 ,
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
                             String aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      siradig_codigosloaddvcombo.this.AV15ComboName = aP0;
      siradig_codigosloaddvcombo.this.AV16TrnMode = aP1;
      siradig_codigosloaddvcombo.this.AV17IsDynamicCall = aP2;
      siradig_codigosloaddvcombo.this.AV18CliCod = aP3;
      siradig_codigosloaddvcombo.this.AV19SiraTipo = aP4;
      siradig_codigosloaddvcombo.this.AV20SiraCodigo = aP5;
      siradig_codigosloaddvcombo.this.AV29Cond_CliCod = aP6;
      siradig_codigosloaddvcombo.this.AV12SearchTxt = aP7;
      siradig_codigosloaddvcombo.this.aP8 = aP8;
      siradig_codigosloaddvcombo.this.aP9 = aP9;
      siradig_codigosloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos", GXv_boolean2) ;
      siradig_codigosloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "SiraConCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SIRACONCODIGO' */
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
      /* 'LOADCOMBOITEMS_SIRACONCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A42ConCodYDesc ,
                                              Integer.valueOf(AV29Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P018C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV29Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A42ConCodYDesc = P018C2_A42ConCodYDesc[0] ;
            n42ConCodYDesc = P018C2_n42ConCodYDesc[0] ;
            A3CliCod = P018C2_A3CliCod[0] ;
            A26ConCodigo = P018C2_A26ConCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P018C3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19SiraTipo, AV20SiraCodigo});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1102SiraCodigo = P018C3_A1102SiraCodigo[0] ;
                  A1101SiraTipo = P018C3_A1101SiraTipo[0] ;
                  A3CliCod = P018C3_A3CliCod[0] ;
                  A1100SiraConCodigo = P018C3_A1100SiraConCodigo[0] ;
                  AV21SelectedValue = A1100SiraConCodigo ;
                  AV28Cond_Aux_CliCod = A3CliCod ;
                  AV27ConCodigo = A1100SiraConCodigo ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV27ConCodigo = AV12SearchTxt ;
               AV28Cond_Aux_CliCod = AV29Cond_CliCod ;
            }
            /* Using cursor P018C4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV28Cond_Aux_CliCod), AV27ConCodigo});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A3CliCod = P018C4_A3CliCod[0] ;
               A26ConCodigo = P018C4_A26ConCodigo[0] ;
               A42ConCodYDesc = P018C4_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P018C4_n42ConCodYDesc[0] ;
               AV22SelectedText = A42ConCodYDesc ;
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
      this.aP8[0] = siradig_codigosloaddvcombo.this.AV21SelectedValue;
      this.aP9[0] = siradig_codigosloaddvcombo.this.AV22SelectedText;
      this.aP10[0] = siradig_codigosloaddvcombo.this.AV23Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV23Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A42ConCodYDesc = "" ;
      P018C2_A42ConCodYDesc = new String[] {""} ;
      P018C2_n42ConCodYDesc = new boolean[] {false} ;
      P018C2_A3CliCod = new int[1] ;
      P018C2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P018C3_A1102SiraCodigo = new String[] {""} ;
      P018C3_A1101SiraTipo = new String[] {""} ;
      P018C3_A3CliCod = new int[1] ;
      P018C3_A1100SiraConCodigo = new String[] {""} ;
      A1102SiraCodigo = "" ;
      A1101SiraTipo = "" ;
      A1100SiraConCodigo = "" ;
      AV27ConCodigo = "" ;
      P018C4_A3CliCod = new int[1] ;
      P018C4_A26ConCodigo = new String[] {""} ;
      P018C4_A42ConCodYDesc = new String[] {""} ;
      P018C4_n42ConCodYDesc = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradig_codigosloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P018C2_A42ConCodYDesc, P018C2_n42ConCodYDesc, P018C2_A3CliCod, P018C2_A26ConCodigo
            }
            , new Object[] {
            P018C3_A1102SiraCodigo, P018C3_A1101SiraTipo, P018C3_A3CliCod, P018C3_A1100SiraConCodigo
            }
            , new Object[] {
            P018C4_A3CliCod, P018C4_A26ConCodigo, P018C4_A42ConCodYDesc, P018C4_n42ConCodYDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV29Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int AV28Cond_Aux_CliCod ;
   private String AV16TrnMode ;
   private String AV19SiraTipo ;
   private String AV20SiraCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1102SiraCodigo ;
   private String A1101SiraTipo ;
   private String A1100SiraConCodigo ;
   private String AV27ConCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private String AV23Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A42ConCodYDesc ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P018C2_A42ConCodYDesc ;
   private boolean[] P018C2_n42ConCodYDesc ;
   private int[] P018C2_A3CliCod ;
   private String[] P018C2_A26ConCodigo ;
   private String[] P018C3_A1102SiraCodigo ;
   private String[] P018C3_A1101SiraTipo ;
   private int[] P018C3_A3CliCod ;
   private String[] P018C3_A1100SiraConCodigo ;
   private int[] P018C4_A3CliCod ;
   private String[] P018C4_A26ConCodigo ;
   private String[] P018C4_A42ConCodYDesc ;
   private boolean[] P018C4_n42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class siradig_codigosloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P018C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A42ConCodYDesc ,
                                          int AV29Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ConCodYDesc, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConCodYDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodYDesc" ;
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
                  return conditional_P018C2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P018C3", "SELECT SiraCodigo, SiraTipo, CliCod, SiraConCodigo FROM siradig_codigos WHERE CliCod = ? and SiraTipo = ( ?) and SiraCodigo = ( ?) ORDER BY CliCod, SiraTipo, SiraCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P018C4", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

