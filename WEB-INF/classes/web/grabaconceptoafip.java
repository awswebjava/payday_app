package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaconceptoafip extends GXProcedure
{
   public grabaconceptoafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaconceptoafip.class ), "" );
   }

   public grabaconceptoafip( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        web.SdtConceptosAfipWizardData aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             web.SdtConceptosAfipWizardData aP2 )
   {
      grabaconceptoafip.this.AV10CliCod = aP0;
      grabaconceptoafip.this.AV11ConCodPropio = aP1;
      grabaconceptoafip.this.AV8ConceptosAfipWizardData = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ConceptoAfip.Load(AV10CliCod, AV11ConCodPropio);
      if ( ! (GXutil.strcmp("", AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto())==0) )
      {
         AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipconcepto( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto() );
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre())==0) )
         {
            AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipconcepto( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre() );
         }
      }
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipsipaapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipsipacont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipinssjypapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipinssjypcont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipobrasocapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipobrasoccont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipfonsolredapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipfonsolredcont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafiprenateaapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafiprenateacont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipasigfamcont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipfonnacempcont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipregdifapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipregespapo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafiptipo( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo() );
      AV9ConceptoAfip.setgxTv_SdtConceptoAFIP_Conafipsubt1( AV8ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1() );
      AV9ConceptoAfip.Save();
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaconceptoafip");
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConceptoAfip = new web.SdtConceptoAFIP(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaconceptoafip__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV11ConCodPropio ;
   private IDataStoreProvider pr_default ;
   private web.SdtConceptosAfipWizardData AV8ConceptosAfipWizardData ;
   private web.SdtConceptoAFIP AV9ConceptoAfip ;
}

final  class grabaconceptoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

