package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresabancosloaddvcombo extends GXProcedure
{
   public empresabancosloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabancosloaddvcombo.class ), "" );
   }

   public empresabancosloaddvcombo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> executeUdp( String aP0 ,
                                                                                    String aP1 ,
                                                                                    int aP2 ,
                                                                                    short aP3 ,
                                                                                    String aP4 ,
                                                                                    String[] aP5 )
   {
      empresabancosloaddvcombo.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 )
   {
      empresabancosloaddvcombo.this.AV13ComboName = aP0;
      empresabancosloaddvcombo.this.AV14TrnMode = aP1;
      empresabancosloaddvcombo.this.AV15CliCod = aP2;
      empresabancosloaddvcombo.this.AV16EmpCod = aP3;
      empresabancosloaddvcombo.this.AV17EmpBanCod = aP4;
      empresabancosloaddvcombo.this.aP5 = aP5;
      empresabancosloaddvcombo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos", GXv_boolean2) ;
      empresabancosloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV13ComboName, "EmpBanCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPBANCOD' */
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
      /* 'LOADCOMBOITEMS_EMPBANCOD' Routine */
      returnInSub = false ;
      /* Using cursor P028W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P028W2_A3CliCod[0] ;
         A7BanCod = P028W2_A7BanCod[0] ;
         A117BanDescrip = P028W2_A117BanDescrip[0] ;
         AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A7BanCod );
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A117BanDescrip );
         AV11Combo_Data.add(AV12Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV14TrnMode, "INS") != 0 )
      {
         /* Using cursor P028W3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV16EmpCod), AV17EmpBanCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1966EmpBanCod = P028W3_A1966EmpBanCod[0] ;
            A1EmpCod = P028W3_A1EmpCod[0] ;
            A3CliCod = P028W3_A3CliCod[0] ;
            AV18SelectedValue = A1966EmpBanCod ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV17EmpBanCod)==0) )
         {
            AV18SelectedValue = AV17EmpBanCod ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = empresabancosloaddvcombo.this.AV18SelectedValue;
      this.aP6[0] = empresabancosloaddvcombo.this.AV11Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18SelectedValue = "" ;
      AV11Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      P028W2_A3CliCod = new int[1] ;
      P028W2_A7BanCod = new String[] {""} ;
      P028W2_A117BanDescrip = new String[] {""} ;
      A7BanCod = "" ;
      A117BanDescrip = "" ;
      AV12Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P028W3_A1966EmpBanCod = new String[] {""} ;
      P028W3_A1EmpCod = new short[1] ;
      P028W3_A3CliCod = new int[1] ;
      A1966EmpBanCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabancosloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P028W2_A3CliCod, P028W2_A7BanCod, P028W2_A117BanDescrip
            }
            , new Object[] {
            P028W3_A1966EmpBanCod, P028W3_A1EmpCod, P028W3_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int A3CliCod ;
   private String AV14TrnMode ;
   private String AV17EmpBanCod ;
   private String scmdbuf ;
   private String A7BanCod ;
   private String A1966EmpBanCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV13ComboName ;
   private String AV18SelectedValue ;
   private String A117BanDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P028W2_A3CliCod ;
   private String[] P028W2_A7BanCod ;
   private String[] P028W2_A117BanDescrip ;
   private String[] P028W3_A1966EmpBanCod ;
   private short[] P028W3_A1EmpCod ;
   private int[] P028W3_A3CliCod ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV11Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV12Combo_DataItem ;
}

final  class empresabancosloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028W2", "SELECT CliCod, BanCod, BanDescrip FROM Banco WHERE CliCod = ? ORDER BY CliCod, BanDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P028W3", "SELECT EmpBanCod, EmpCod, CliCod FROM EmpresaBancos WHERE CliCod = ? and EmpCod = ? and EmpBanCod = ( ?) ORDER BY CliCod, EmpCod, EmpBanCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
      }
   }

}

