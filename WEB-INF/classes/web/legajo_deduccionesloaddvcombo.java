package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_deduccionesloaddvcombo extends GXProcedure
{
   public legajo_deduccionesloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_deduccionesloaddvcombo.class ), "" );
   }

   public legajo_deduccionesloaddvcombo( int remoteHandle ,
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
                             int aP5 ,
                             int aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      legajo_deduccionesloaddvcombo.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
                        int aP6 ,
                        int aP7 ,
                        short aP8 ,
                        String aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             int aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      legajo_deduccionesloaddvcombo.this.AV17ComboName = aP0;
      legajo_deduccionesloaddvcombo.this.AV19TrnMode = aP1;
      legajo_deduccionesloaddvcombo.this.AV22IsDynamicCall = aP2;
      legajo_deduccionesloaddvcombo.this.AV26CliCod = aP3;
      legajo_deduccionesloaddvcombo.this.AV27EmpCod = aP4;
      legajo_deduccionesloaddvcombo.this.AV28LegNumero = aP5;
      legajo_deduccionesloaddvcombo.this.AV29LegDedSec = aP6;
      legajo_deduccionesloaddvcombo.this.AV30Cond_CliCod = aP7;
      legajo_deduccionesloaddvcombo.this.AV31Cond_EmpCod = aP8;
      legajo_deduccionesloaddvcombo.this.AV12SearchTxt = aP9;
      legajo_deduccionesloaddvcombo.this.aP10 = aP10;
      legajo_deduccionesloaddvcombo.this.aP11 = aP11;
      legajo_deduccionesloaddvcombo.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV32SubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocalculogananciasded1(remoteHandle, context).execute( GXv_char2) ;
      legajo_deduccionesloaddvcombo.this.GXt_char1 = GXv_char2[0] ;
      AV32SubTipoConCod1 = GXt_char1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones", GXv_boolean4) ;
      legajo_deduccionesloaddvcombo.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "LegNumero") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGNUMERO' */
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
      /* 'LOADCOMBOITEMS_LEGNUMERO' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A250LegIdNomApe ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(AV30Cond_CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Short.valueOf(AV31Cond_EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00212 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV30Cond_CliCod), Short.valueOf(AV31Cond_EmpCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P00212_A3CliCod[0] ;
            A1EmpCod = P00212_A1EmpCod[0] ;
            A250LegIdNomApe = P00212_A250LegIdNomApe[0] ;
            A6LegNumero = P00212_A6LegNumero[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            /* Using cursor P00213 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV28LegNumero), Integer.valueOf(AV29LegDedSec)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A83LegDedSec = P00213_A83LegDedSec[0] ;
               A6LegNumero = P00213_A6LegNumero[0] ;
               A1EmpCod = P00213_A1EmpCod[0] ;
               A3CliCod = P00213_A3CliCod[0] ;
               A250LegIdNomApe = P00213_A250LegIdNomApe[0] ;
               A250LegIdNomApe = P00213_A250LegIdNomApe[0] ;
               AV16SelectedValue = ((0==A6LegNumero) ? "" : GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
               AV21SelectedText = A250LegIdNomApe ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV28LegNumero) )
            {
               AV16SelectedValue = GXutil.trim( GXutil.str( AV28LegNumero, 8, 0)) ;
               /* Using cursor P00214 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV30Cond_CliCod), Short.valueOf(AV31Cond_EmpCod), Integer.valueOf(AV28LegNumero)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1EmpCod = P00214_A1EmpCod[0] ;
                  A3CliCod = P00214_A3CliCod[0] ;
                  A6LegNumero = P00214_A6LegNumero[0] ;
                  A250LegIdNomApe = P00214_A250LegIdNomApe[0] ;
                  AV21SelectedText = A250LegIdNomApe ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = legajo_deduccionesloaddvcombo.this.AV16SelectedValue;
      this.aP11[0] = legajo_deduccionesloaddvcombo.this.AV21SelectedText;
      this.aP12[0] = legajo_deduccionesloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV13Combo_DataJson = "" ;
      AV32SubTipoConCod1 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A250LegIdNomApe = "" ;
      P00212_A3CliCod = new int[1] ;
      P00212_A1EmpCod = new short[1] ;
      P00212_A250LegIdNomApe = new String[] {""} ;
      P00212_A6LegNumero = new int[1] ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P00213_A83LegDedSec = new int[1] ;
      P00213_A6LegNumero = new int[1] ;
      P00213_A1EmpCod = new short[1] ;
      P00213_A3CliCod = new int[1] ;
      P00213_A250LegIdNomApe = new String[] {""} ;
      P00214_A1EmpCod = new short[1] ;
      P00214_A3CliCod = new int[1] ;
      P00214_A6LegNumero = new int[1] ;
      P00214_A250LegIdNomApe = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_deduccionesloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00212_A3CliCod, P00212_A1EmpCod, P00212_A250LegIdNomApe, P00212_A6LegNumero
            }
            , new Object[] {
            P00213_A83LegDedSec, P00213_A6LegNumero, P00213_A1EmpCod, P00213_A3CliCod, P00213_A250LegIdNomApe
            }
            , new Object[] {
            P00214_A1EmpCod, P00214_A3CliCod, P00214_A6LegNumero, P00214_A250LegIdNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV27EmpCod ;
   private short AV31Cond_EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV26CliCod ;
   private int AV28LegNumero ;
   private int AV29LegDedSec ;
   private int AV30Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private String AV19TrnMode ;
   private String AV32SubTipoConCod1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private boolean AV22IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A250LegIdNomApe ;
   private String[] aP12 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P00212_A3CliCod ;
   private short[] P00212_A1EmpCod ;
   private String[] P00212_A250LegIdNomApe ;
   private int[] P00212_A6LegNumero ;
   private int[] P00213_A83LegDedSec ;
   private int[] P00213_A6LegNumero ;
   private short[] P00213_A1EmpCod ;
   private int[] P00213_A3CliCod ;
   private String[] P00213_A250LegIdNomApe ;
   private short[] P00214_A1EmpCod ;
   private int[] P00214_A3CliCod ;
   private int[] P00214_A6LegNumero ;
   private String[] P00214_A250LegIdNomApe ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class legajo_deduccionesloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00212( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A250LegIdNomApe ,
                                          int A3CliCod ,
                                          int AV30Cond_CliCod ,
                                          short A1EmpCod ,
                                          short AV31Cond_EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegIdNomApe, LegNumero FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegIdNomApe) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LegIdNomApe" ;
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
                  return conditional_P00212(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00212", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00213", "SELECT T1.LegDedSec, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LegIdNomApe FROM (legajo_deducciones T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegDedSec = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00214", "SELECT EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

