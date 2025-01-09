package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_gridstateaddcombofiltervalue extends GXProcedure
{
   public wwp_gridstateaddcombofiltervalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_gridstateaddcombofiltervalue.class ), "" );
   }

   public wwp_gridstateaddcombofiltervalue( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( web.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        String aP4 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP5 ,
                        boolean aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             String aP4 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP5 ,
                             boolean aP6 )
   {
      wwp_gridstateaddcombofiltervalue.this.AV14GridState = aP0[0];
      this.aP0 = aP0;
      wwp_gridstateaddcombofiltervalue.this.AV12FilterName = aP1;
      wwp_gridstateaddcombofiltervalue.this.AV11FilterDsc = aP2;
      wwp_gridstateaddcombofiltervalue.this.AV8AddFitler = aP3;
      wwp_gridstateaddcombofiltervalue.this.AV13FilterValue = aP4;
      wwp_gridstateaddcombofiltervalue.this.AV10ComboItems = aP5[0];
      this.aP5 = aP5;
      wwp_gridstateaddcombofiltervalue.this.AV16HasMultipleSelection = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8AddFitler )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( AV12FilterName );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Dsc( AV11FilterDsc );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV13FilterValue );
         if ( AV16HasMultipleSelection )
         {
            AV17FilterValueCol.fromJSonString(AV13FilterValue, null);
            AV21GXV1 = 1 ;
            while ( AV21GXV1 <= AV17FilterValueCol.size() )
            {
               AV18FilterValueItem = (String)AV17FilterValueCol.elementAt(-1+AV21GXV1) ;
               AV22GXV2 = 1 ;
               while ( AV22GXV2 <= AV10ComboItems.size() )
               {
                  AV9ComboItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV10ComboItems.elementAt(-1+AV22GXV2));
                  if ( GXutil.strcmp(GXutil.trim( AV9ComboItem.getgxTv_SdtDVB_SDTComboData_Item_Id()), GXutil.trim( AV18FilterValueItem)) == 0 )
                  {
                     AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valueto( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()+((GXutil.strcmp("", AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())==0) ? "" : ", ")+AV9ComboItem.getgxTv_SdtDVB_SDTComboData_Item_Title() );
                     if (true) break;
                  }
                  AV22GXV2 = (int)(AV22GXV2+1) ;
               }
               AV21GXV1 = (int)(AV21GXV1+1) ;
            }
         }
         else
         {
            AV23GXV3 = 1 ;
            while ( AV23GXV3 <= AV10ComboItems.size() )
            {
               AV9ComboItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV10ComboItems.elementAt(-1+AV23GXV3));
               if ( GXutil.strcmp(GXutil.trim( AV9ComboItem.getgxTv_SdtDVB_SDTComboData_Item_Id()), GXutil.trim( AV13FilterValue)) == 0 )
               {
                  AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valueto( AV9ComboItem.getgxTv_SdtDVB_SDTComboData_Item_Title() );
                  if (true) break;
               }
               AV23GXV3 = (int)(AV23GXV3+1) ;
            }
         }
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_gridstateaddcombofiltervalue.this.AV14GridState;
      this.aP5[0] = wwp_gridstateaddcombofiltervalue.this.AV10ComboItems;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV17FilterValueCol = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18FilterValueItem = "" ;
      AV9ComboItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV21GXV1 ;
   private int AV22GXV2 ;
   private int AV23GXV3 ;
   private boolean AV8AddFitler ;
   private boolean AV16HasMultipleSelection ;
   private String AV12FilterName ;
   private String AV11FilterDsc ;
   private String AV13FilterValue ;
   private String AV18FilterValueItem ;
   private web.wwpbaseobjects.SdtWWPGridState[] aP0 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP5 ;
   private GXSimpleCollection<String> AV17FilterValueCol ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV10ComboItems ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV9ComboItem ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
}

