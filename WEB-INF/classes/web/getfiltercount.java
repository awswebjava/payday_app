package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getfiltercount extends GXProcedure
{
   public getfiltercount( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getfiltercount.class ), "" );
   }

   public getfiltercount( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                             short[] aP1 )
   {
      getfiltercount.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                        short[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                             short[] aP1 ,
                             String[] aP2 )
   {
      getfiltercount.this.AV10GridState = aP0;
      getfiltercount.this.aP1 = aP1;
      getfiltercount.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8filterCount = (short)(0) ;
      AV9filtrosTexto = "" ;
      AV14GXV1 = 1 ;
      while ( AV14GXV1 <= AV10GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV11GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV10GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV14GXV1));
         if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()))==0) && ( GXutil.strSearch( AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), httpContext.getMessage( "PARM_", ""), 1) == 0 ) )
         {
            AV8filterCount = (short)(AV8filterCount+1) ;
            if ( AV8filterCount > 1 )
            {
               AV9filtrosTexto += ", " ;
            }
            if ( GXutil.strcmp(GXutil.trim( AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Dsc()), httpContext.getMessage( "Ver", "")) == 0 )
            {
               AV9filtrosTexto += httpContext.getMessage( "Ver conceptos del recibo", "") ;
            }
            else
            {
               AV9filtrosTexto += GXutil.trim( AV11GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Dsc()) ;
            }
         }
         AV14GXV1 = (int)(AV14GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getfiltercount.this.AV8filterCount;
      this.aP2[0] = getfiltercount.this.AV9filtrosTexto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9filtrosTexto = "" ;
      AV11GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8filterCount ;
   private short Gx_err ;
   private int AV14GXV1 ;
   private String AV9filtrosTexto ;
   private String[] aP2 ;
   private short[] aP1 ;
   private web.wwpbaseobjects.SdtWWPGridState AV10GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV11GridStateFilterValue ;
}

