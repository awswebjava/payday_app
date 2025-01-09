package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importacion_legajofamilialoaddvcombo extends GXProcedure
{
   public importacion_legajofamilialoaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajofamilialoaddvcombo.class ), "" );
   }

   public importacion_legajofamilialoaddvcombo( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> executeUdp( String aP0 ,
                                                                                    String aP1 ,
                                                                                    int aP2 ,
                                                                                    short aP3 ,
                                                                                    int aP4 ,
                                                                                    short aP5 ,
                                                                                    String[] aP6 )
   {
      importacion_legajofamilialoaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        short aP5 ,
                        String[] aP6 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             short aP5 ,
                             String[] aP6 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      importacion_legajofamilialoaddvcombo.this.AV14ComboName = aP0;
      importacion_legajofamilialoaddvcombo.this.AV27TrnMode = aP1;
      importacion_legajofamilialoaddvcombo.this.AV10CliCod = aP2;
      importacion_legajofamilialoaddvcombo.this.AV15EmpCod = aP3;
      importacion_legajofamilialoaddvcombo.this.AV21MigrLegNumero = aP4;
      importacion_legajofamilialoaddvcombo.this.AV20MigrLegFamSec = aP5;
      importacion_legajofamilialoaddvcombo.this.aP6 = aP6;
      importacion_legajofamilialoaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV18MigrLegFamAdh ;
      GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char3[0] = "" ;
      GXv_char4[0] = AV19MigrLegFamParen ;
      GXv_char5[0] = "" ;
      GXv_date6[0] = GXutil.nullDate() ;
      GXv_char7[0] = "" ;
      new web.getmigrfamiliadatos(remoteHandle, context).execute( AV10CliCod, AV15EmpCod, AV21MigrLegNumero, AV20MigrLegFamSec, GXv_char1, GXv_decimal2, GXv_char3, GXv_char4, GXv_char5, GXv_date6, GXv_char7) ;
      importacion_legajofamilialoaddvcombo.this.AV18MigrLegFamAdh = GXv_char1[0] ;
      importacion_legajofamilialoaddvcombo.this.AV19MigrLegFamParen = GXv_char4[0] ;
      GXt_boolean8 = AV17IsAuthorized ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia", GXv_boolean9) ;
      importacion_legajofamilialoaddvcombo.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV17IsAuthorized = GXt_boolean8 ;
      if ( AV17IsAuthorized )
      {
         GXv_SdtWWPContext10[0] = AV29WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext10) ;
         AV29WWPContext = GXv_SdtWWPContext10[0] ;
         if ( GXutil.strcmp(AV14ComboName, "MigrLegFamParen") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGFAMPAREN' */
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
      /* 'LOADCOMBOITEMS_MIGRLEGFAMPAREN' Routine */
      returnInSub = false ;
      AV9campo = httpContext.getMessage( "Parentesco", "") ;
      AV28valor = AV19MigrLegFamParen ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      AV11Combo_Data.sort("Title");
      if ( GXutil.strcmp(AV27TrnMode, "INS") != 0 )
      {
         /* Using cursor P01YR2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV15EmpCod), Integer.valueOf(AV21MigrLegNumero), Short.valueOf(AV20MigrLegFamSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2078MigrLegFamSec = P01YR2_A2078MigrLegFamSec[0] ;
            A87MigrLegNumero = P01YR2_A87MigrLegNumero[0] ;
            A1EmpCod = P01YR2_A1EmpCod[0] ;
            A3CliCod = P01YR2_A3CliCod[0] ;
            A2079MigrLegFamParen = P01YR2_A2079MigrLegFamParen[0] ;
            AV24SelectedValue = A2079MigrLegFamParen ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGFAMADH' Routine */
      returnInSub = false ;
      AV9campo = httpContext.getMessage( "Adherente", "") ;
      AV28valor = AV18MigrLegFamAdh ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
   }

   public void S121( )
   {
      /* 'ARMAR COLECCIONES' Routine */
      returnInSub = false ;
      GXv_objcol_char11[0] = AV26similares ;
      GXv_objcol_char12[0] = AV22otras ;
      GXv_char7[0] = "" ;
      GXv_boolean9[0] = false ;
      GXv_char5[0] = "" ;
      GXv_boolean13[0] = AV8existe ;
      GXv_boolean14[0] = false ;
      new web.loadcombomigr2(remoteHandle, context).execute( AV10CliCod, AV15EmpCod, AV21MigrLegNumero, AV9campo, "", AV28valor, GXv_objcol_char11, GXv_objcol_char12, GXv_char7, GXv_boolean9, GXv_char5, GXv_boolean13, GXv_boolean14) ;
      AV26similares = GXv_objcol_char11[0] ;
      AV22otras = GXv_objcol_char12[0] ;
      importacion_legajofamilialoaddvcombo.this.AV8existe = GXv_boolean13[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&valor ", "")+AV28valor) ;
      if ( ! (GXutil.strcmp("", AV28valor)==0) )
      {
         AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&existe ", "")+GXutil.trim( GXutil.booltostr( AV8existe))+httpContext.getMessage( " campo ", "")+AV9campo) ;
         if ( ! AV8existe )
         {
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( AV28valor) );
            GXt_char15 = "" ;
            GXv_char7[0] = GXt_char15 ;
            new web.mensajemigrselvalida(remoteHandle, context).execute( AV10CliCod, GXv_char7) ;
            importacion_legajofamilialoaddvcombo.this.GXt_char15 = GXv_char7[0] ;
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXt_char15 );
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "agrega como no valido", "")) ;
         }
         else
         {
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( AV28valor) );
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( AV28valor) );
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "agrega como valido", "")) ;
         }
         AV11Combo_Data.add(AV12Combo_DataItem, 0);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&similares ", "")+AV26similares.toJSonString(false)) ;
      if ( AV26similares.size() > 0 )
      {
         AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( httpContext.getMessage( "Similares", "") );
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "Similares", "") );
         AV11Combo_Data.add(AV12Combo_DataItem, 0);
         AV16i = (short)(1) ;
         while ( AV16i <= AV26similares.size() )
         {
            AV30itemChildren = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV30itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV26similares.elementAt(-1+AV16i)) );
            AV30itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV26similares.elementAt(-1+AV16i)) );
            AV12Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV30itemChildren, 0);
            AV16i = (short)(AV16i+1) ;
         }
         if ( AV22otras.size() > 0 )
         {
            AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( httpContext.getMessage( "Otras", "") );
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "Otras", "") );
            AV11Combo_Data.add(AV12Combo_DataItem, 0);
            AV16i = (short)(1) ;
            while ( AV16i <= AV22otras.size() )
            {
               AV30itemChildren = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV30itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV22otras.elementAt(-1+AV16i)) );
               AV30itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV22otras.elementAt(-1+AV16i)) );
               AV12Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV30itemChildren, 0);
               AV16i = (short)(AV16i+1) ;
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&otras ", "")+AV22otras.toJSonString(false)) ;
         AV16i = (short)(1) ;
         while ( AV16i <= AV22otras.size() )
         {
            AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV22otras.elementAt(-1+AV16i)) );
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV22otras.elementAt(-1+AV16i)) );
            AV12Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().clear();
            AV11Combo_Data.add(AV12Combo_DataItem, 0);
            AV16i = (short)(AV16i+1) ;
         }
      }
      AV16i = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&otras.Count ", "")+GXutil.trim( GXutil.str( AV22otras.size(), 9, 0))+httpContext.getMessage( " similares ", "")+GXutil.str( AV26similares.size(), 9, 0)) ;
   }

   protected void cleanup( )
   {
      this.aP6[0] = importacion_legajofamilialoaddvcombo.this.AV24SelectedValue;
      this.aP7[0] = importacion_legajofamilialoaddvcombo.this.AV11Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24SelectedValue = "" ;
      AV11Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV18MigrLegFamAdh = "" ;
      GXv_char1 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_char3 = new String[1] ;
      AV19MigrLegFamParen = "" ;
      GXv_char4 = new String[1] ;
      GXv_date6 = new java.util.Date[1] ;
      AV29WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext10 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV9campo = "" ;
      AV28valor = "" ;
      scmdbuf = "" ;
      P01YR2_A2078MigrLegFamSec = new short[1] ;
      P01YR2_A87MigrLegNumero = new int[1] ;
      P01YR2_A1EmpCod = new short[1] ;
      P01YR2_A3CliCod = new int[1] ;
      P01YR2_A2079MigrLegFamParen = new String[] {""} ;
      A2079MigrLegFamParen = "" ;
      AV26similares = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char11 = new GXSimpleCollection[1] ;
      AV22otras = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char12 = new GXSimpleCollection[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char5 = new String[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV34Pgmname = "" ;
      AV12Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      GXt_char15 = "" ;
      GXv_char7 = new String[1] ;
      AV30itemChildren = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajofamilialoaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01YR2_A2078MigrLegFamSec, P01YR2_A87MigrLegNumero, P01YR2_A1EmpCod, P01YR2_A3CliCod, P01YR2_A2079MigrLegFamParen
            }
         }
      );
      AV34Pgmname = "importacion_legajoFamiliaLoadDVCombo" ;
      /* GeneXus formulas. */
      AV34Pgmname = "importacion_legajoFamiliaLoadDVCombo" ;
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV20MigrLegFamSec ;
   private short A2078MigrLegFamSec ;
   private short A1EmpCod ;
   private short AV16i ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV21MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV27TrnMode ;
   private String AV18MigrLegFamAdh ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV9campo ;
   private String scmdbuf ;
   private String GXv_char5[] ;
   private String AV34Pgmname ;
   private String GXt_char15 ;
   private String GXv_char7[] ;
   private java.util.Date GXv_date6[] ;
   private boolean AV17IsAuthorized ;
   private boolean GXt_boolean8 ;
   private boolean returnInSub ;
   private boolean GXv_boolean9[] ;
   private boolean AV8existe ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean14[] ;
   private String AV14ComboName ;
   private String AV24SelectedValue ;
   private String AV19MigrLegFamParen ;
   private String AV28valor ;
   private String A2079MigrLegFamParen ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P01YR2_A2078MigrLegFamSec ;
   private int[] P01YR2_A87MigrLegNumero ;
   private short[] P01YR2_A1EmpCod ;
   private int[] P01YR2_A3CliCod ;
   private String[] P01YR2_A2079MigrLegFamParen ;
   private GXSimpleCollection<String> AV26similares ;
   private GXSimpleCollection<String> GXv_objcol_char11[] ;
   private GXSimpleCollection<String> AV22otras ;
   private GXSimpleCollection<String> GXv_objcol_char12[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV11Combo_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV12Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV30itemChildren ;
   private web.wwpbaseobjects.SdtWWPContext AV29WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext10[] ;
}

final  class importacion_legajofamilialoaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YR2", "SELECT MigrLegFamSec, MigrLegNumero, EmpCod, CliCod, MigrLegFamParen FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? and MigrLegFamSec = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

