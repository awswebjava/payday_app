package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deduccionessolapaloaddvcombo extends GXProcedure
{
   public deduccionessolapaloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deduccionessolapaloaddvcombo.class ), "" );
   }

   public deduccionessolapaloaddvcombo( int remoteHandle ,
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
                                                                                    int aP5 ,
                                                                                    String[] aP6 )
   {
      deduccionessolapaloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        int aP5 ,
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
                             int aP5 ,
                             String[] aP6 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      deduccionessolapaloaddvcombo.this.AV17ComboName = aP0;
      deduccionessolapaloaddvcombo.this.AV19TrnMode = aP1;
      deduccionessolapaloaddvcombo.this.AV24CliCod = aP2;
      deduccionessolapaloaddvcombo.this.AV25EmpCod = aP3;
      deduccionessolapaloaddvcombo.this.AV26LegNumero = aP4;
      deduccionessolapaloaddvcombo.this.AV27LegDedSec = aP5;
      deduccionessolapaloaddvcombo.this.aP6 = aP6;
      deduccionessolapaloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV30SubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocalculogananciasded1(remoteHandle, context).execute( GXv_char2) ;
      deduccionessolapaloaddvcombo.this.GXt_char1 = GXv_char2[0] ;
      AV30SubTipoConCod1 = GXt_char1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa", GXv_boolean4) ;
      deduccionessolapaloaddvcombo.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
         if ( GXutil.strcmp(AV17ComboName, "LegDedConCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGDEDCONCODIGO' */
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
      /* 'LOADCOMBOITEMS_LEGDEDCONCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P00272 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV24CliCod), AV30SubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P00272_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00272_n38SubTipoConCod1[0] ;
         A37TipoConCod = P00272_A37TipoConCod[0] ;
         A3CliCod = P00272_A3CliCod[0] ;
         A26ConCodigo = P00272_A26ConCodigo[0] ;
         A42ConCodYDesc = P00272_A42ConCodYDesc[0] ;
         n42ConCodYDesc = P00272_n42ConCodYDesc[0] ;
         AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV14Combo_Data.add(AV15Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
      {
         /* Using cursor P00273 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV24CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV26LegNumero), Integer.valueOf(AV27LegDedSec)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A83LegDedSec = P00273_A83LegDedSec[0] ;
            A6LegNumero = P00273_A6LegNumero[0] ;
            A1EmpCod = P00273_A1EmpCod[0] ;
            A3CliCod = P00273_A3CliCod[0] ;
            A84LegDedConCodigo = P00273_A84LegDedConCodigo[0] ;
            AV16SelectedValue = A84LegDedConCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = deduccionessolapaloaddvcombo.this.AV16SelectedValue;
      this.aP7[0] = deduccionessolapaloaddvcombo.this.AV14Combo_Data;
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
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV30SubTipoConCod1 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      P00272_A38SubTipoConCod1 = new String[] {""} ;
      P00272_n38SubTipoConCod1 = new boolean[] {false} ;
      P00272_A37TipoConCod = new String[] {""} ;
      P00272_A3CliCod = new int[1] ;
      P00272_A26ConCodigo = new String[] {""} ;
      P00272_A42ConCodYDesc = new String[] {""} ;
      P00272_n42ConCodYDesc = new boolean[] {false} ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P00273_A83LegDedSec = new int[1] ;
      P00273_A6LegNumero = new int[1] ;
      P00273_A1EmpCod = new short[1] ;
      P00273_A3CliCod = new int[1] ;
      P00273_A84LegDedConCodigo = new String[] {""} ;
      A84LegDedConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deduccionessolapaloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00272_A38SubTipoConCod1, P00272_n38SubTipoConCod1, P00272_A37TipoConCod, P00272_A3CliCod, P00272_A26ConCodigo, P00272_A42ConCodYDesc, P00272_n42ConCodYDesc
            }
            , new Object[] {
            P00273_A83LegDedSec, P00273_A6LegNumero, P00273_A1EmpCod, P00273_A3CliCod, P00273_A84LegDedConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV26LegNumero ;
   private int AV27LegDedSec ;
   private int A3CliCod ;
   private int A83LegDedSec ;
   private int A6LegNumero ;
   private String AV19TrnMode ;
   private String AV30SubTipoConCod1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String A84LegDedConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean n38SubTipoConCod1 ;
   private boolean n42ConCodYDesc ;
   private String AV17ComboName ;
   private String AV16SelectedValue ;
   private String A42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P00272_A38SubTipoConCod1 ;
   private boolean[] P00272_n38SubTipoConCod1 ;
   private String[] P00272_A37TipoConCod ;
   private int[] P00272_A3CliCod ;
   private String[] P00272_A26ConCodigo ;
   private String[] P00272_A42ConCodYDesc ;
   private boolean[] P00272_n42ConCodYDesc ;
   private int[] P00273_A83LegDedSec ;
   private int[] P00273_A6LegNumero ;
   private short[] P00273_A1EmpCod ;
   private int[] P00273_A3CliCod ;
   private String[] P00273_A84LegDedConCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class deduccionessolapaloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00272", "SELECT SubTipoConCod1, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and TipoConCod = ( 'CAL_ARG') and SubTipoConCod1 = ( ?) ORDER BY CliCod, TipoConCod, SubTipoConCod1, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00273", "SELECT LegDedSec, LegNumero, EmpCod, CliCod, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegDedSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegDedSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

