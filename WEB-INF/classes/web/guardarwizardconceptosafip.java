package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class guardarwizardconceptosafip extends GXProcedure
{
   public guardarwizardconceptosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( guardarwizardconceptosafip.class ), "" );
   }

   public guardarwizardconceptosafip( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      guardarwizardconceptosafip.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      guardarwizardconceptosafip.this.AV12CliCod = aP0;
      guardarwizardconceptosafip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8WizardSteps.fromJSonString(AV9websession.getValue(httpContext.getMessage( "&WizardSteps", "")), null);
      AV17GXV1 = 1 ;
      while ( AV17GXV1 <= AV8WizardSteps.size() )
      {
         AV10step = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV8WizardSteps.elementAt(-1+AV17GXV1));
         if ( ( GXutil.strcmp(AV10step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "Inicio") != 0 ) && ( GXutil.strcmp(AV10step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "Completado") != 0 ) )
         {
            AV13ConceptosAfipWizardData = (web.SdtConceptosAfipWizardData)new web.SdtConceptosAfipWizardData(remoteHandle, context);
            AV13ConceptosAfipWizardData.fromJSonString(AV9websession.getValue(httpContext.getMessage( "ConceptosAfipWizard_", "")+GXutil.trim( AV10step.getgxTv_SdtWizardSteps_WizardStepsItem_Code())), null);
            new web.grabaconceptoafip(remoteHandle, context).execute( AV12CliCod, AV10step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV13ConceptosAfipWizardData) ;
         }
         AV17GXV1 = (int)(AV17GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = guardarwizardconceptosafip.this.AV14error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      AV8WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle);
      AV9websession = httpContext.getWebSession();
      AV10step = new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV13ConceptosAfipWizardData = new web.SdtConceptosAfipWizardData(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12CliCod ;
   private int AV17GXV1 ;
   private String AV14error ;
   private com.genexus.webpanels.WebSession AV9websession ;
   private String[] aP1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV8WizardSteps ;
   private web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV10step ;
   private web.SdtConceptosAfipWizardData AV13ConceptosAfipWizardData ;
}

