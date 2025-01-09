package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_deletefilter extends GXProcedure
{
   public wwp_deletefilter( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_deletefilter.class ), "" );
   }

   public wwp_deletefilter( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( web.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                              String aP1 ,
                              boolean aP2 )
   {
      wwp_deletefilter.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( web.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean[] aP3 )
   {
      wwp_deletefilter.this.AV11GridState = aP0[0];
      this.aP0 = aP0;
      wwp_deletefilter.this.AV10FilterName = aP1;
      wwp_deletefilter.this.AV14IsDynamic = aP2;
      wwp_deletefilter.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9FilterDeleted = false ;
      AV13Index = (short)(1) ;
      if ( AV14IsDynamic )
      {
         AV17GXV1 = 1 ;
         while ( AV17GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() )
         {
            AV8DynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV11GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+AV17GXV1));
            if ( GXutil.strcmp(AV8DynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected(), AV10FilterName) == 0 )
            {
               AV9FilterDeleted = true ;
               if (true) break;
            }
            AV13Index = (short)(AV13Index+1) ;
            AV17GXV1 = (int)(AV17GXV1+1) ;
         }
         if ( AV9FilterDeleted )
         {
            AV11GridState.getgxTv_SdtWWPGridState_Dynamicfilters().removeItem(AV13Index);
         }
      }
      else
      {
         AV18GXV2 = 1 ;
         while ( AV18GXV2 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
         {
            AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV18GXV2));
            if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), AV10FilterName) == 0 )
            {
               AV9FilterDeleted = true ;
               if (true) break;
            }
            AV13Index = (short)(AV13Index+1) ;
            AV18GXV2 = (int)(AV18GXV2+1) ;
         }
         if ( AV9FilterDeleted )
         {
            AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().removeItem(AV13Index);
         }
         if ( GXutil.startsWith( AV10FilterName, "TF") && ! GXutil.endsWith( AV10FilterName, "_SEL") )
         {
            GXv_SdtWWPGridState1[0] = AV11GridState;
            if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState1, AV10FilterName+"_SEL", false) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            AV11GridState = GXv_SdtWWPGridState1[0] ;
            if ( Cond_result )
            {
               AV9FilterDeleted = true ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_deletefilter.this.AV11GridState;
      this.aP3[0] = wwp_deletefilter.this.AV9FilterDeleted;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8DynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState1 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13Index ;
   private short Gx_err ;
   private int AV17GXV1 ;
   private int AV18GXV2 ;
   private boolean AV14IsDynamic ;
   private boolean AV9FilterDeleted ;
   private boolean Cond_result ;
   private String AV10FilterName ;
   private boolean[] aP3 ;
   private web.wwpbaseobjects.SdtWWPGridState[] aP0 ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState1[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV8DynamicFilter ;
}

