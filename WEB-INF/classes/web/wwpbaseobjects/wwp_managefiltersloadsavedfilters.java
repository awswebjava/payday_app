package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_managefiltersloadsavedfilters extends GXProcedure
{
   public wwp_managefiltersloadsavedfilters( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_managefiltersloadsavedfilters.class ), "" );
   }

   public wwp_managefiltersloadsavedfilters( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> executeUdp( String aP0 ,
                                                                                              String aP1 ,
                                                                                              String aP2 ,
                                                                                              boolean aP3 )
   {
      wwp_managefiltersloadsavedfilters.this.aP4 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>[] aP4 )
   {
      wwp_managefiltersloadsavedfilters.this.AV8Key = aP0;
      wwp_managefiltersloadsavedfilters.this.AV14CleanJSFormat = aP1;
      wwp_managefiltersloadsavedfilters.this.AV15TableInternalName = aP2;
      wwp_managefiltersloadsavedfilters.this.AV9HasAdvancedFilters = aP3;
      wwp_managefiltersloadsavedfilters.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_CleanFiltersCaption", "") );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "<#Clean#>" );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fa fa-times-circle" );
      if ( ! (GXutil.strcmp("", AV14CleanJSFormat)==0) )
      {
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent( GXutil.format( AV14CleanJSFormat, AV15TableInternalName, "", "", "", "", "", "", "", "") );
      }
      AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
      AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_SaveFilterAsOption", "") );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "<#Save#>" );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fa fa-save" );
      AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
      if ( AV9HasAdvancedFilters )
      {
         AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_ShowAdvancedFilters", "")+"|"+httpContext.getMessage( "WWP_HideAdvancedFilters", "") );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "<#ADV#>" );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-filter" );
         AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
      }
      AV13ManageFiltersItems.fromxml(new web.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( AV8Key), null, null);
      if ( AV13ManageFiltersItems.size() > 0 )
      {
         AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
         AV18GXV1 = 1 ;
         while ( AV18GXV1 <= AV13ManageFiltersItems.size() )
         {
            AV12ManageFiltersItem = (web.wwpbaseobjects.SdtGridStateCollection_Item)((web.wwpbaseobjects.SdtGridStateCollection_Item)AV13ManageFiltersItems.elementAt(-1+AV18GXV1));
            AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
            AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( AV12ManageFiltersItem.getgxTv_SdtGridStateCollection_Item_Title() );
            AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( AV12ManageFiltersItem.getgxTv_SdtGridStateCollection_Item_Title() );
            AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
            if ( ! (GXutil.strcmp("", AV14CleanJSFormat)==0) )
            {
               AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent( GXutil.format( AV14CleanJSFormat, AV15TableInternalName, "", "", "", "", "", "", "", "") );
            }
            AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
            if ( AV10ManageFiltersData.size() == 13 )
            {
               if (true) break;
            }
            AV18GXV1 = (int)(AV18GXV1+1) ;
         }
         AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
         AV11ManageFiltersDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_ManageFiltersOption", "") );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "<#Manage#>" );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fa fa-cog" );
         AV11ManageFiltersDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent( "" );
         AV10ManageFiltersData.add(AV11ManageFiltersDataItem, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = wwp_managefiltersloadsavedfilters.this.AV10ManageFiltersData;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV11ManageFiltersDataItem = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV13ManageFiltersItems = new GXBaseCollection<web.wwpbaseobjects.SdtGridStateCollection_Item>(web.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV12ManageFiltersItem = new web.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18GXV1 ;
   private boolean AV9HasAdvancedFilters ;
   private String AV8Key ;
   private String AV14CleanJSFormat ;
   private String AV15TableInternalName ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>[] aP4 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV10ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtGridStateCollection_Item> AV13ManageFiltersItems ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV11ManageFiltersDataItem ;
   private web.wwpbaseobjects.SdtGridStateCollection_Item AV12ManageFiltersItem ;
}

