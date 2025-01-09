package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cargarpasowizardconcepto extends GXProcedure
{
   public cargarpasowizardconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cargarpasowizardconcepto.class ), "" );
   }

   public cargarpasowizardconcepto( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.SdtConceptosAfipWizardData executeUdp( int aP0 ,
                                                     String aP1 )
   {
      cargarpasowizardconcepto.this.aP2 = new web.SdtConceptosAfipWizardData[] {new web.SdtConceptosAfipWizardData()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        web.SdtConceptosAfipWizardData[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             web.SdtConceptosAfipWizardData[] aP2 )
   {
      cargarpasowizardconcepto.this.AV8clicod = aP0;
      cargarpasowizardconcepto.this.AV10ConCodPropio = aP1;
      cargarpasowizardconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00GB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), AV10ConCodPropio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A73ConCodPropio = P00GB2_A73ConCodPropio[0] ;
         A3CliCod = P00GB2_A3CliCod[0] ;
         A386ConAFIPConcepto = P00GB2_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = P00GB2_n386ConAFIPConcepto[0] ;
         A141ConAFIPSIPAApo = P00GB2_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = P00GB2_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = P00GB2_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = P00GB2_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = P00GB2_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = P00GB2_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = P00GB2_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = P00GB2_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = P00GB2_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = P00GB2_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = P00GB2_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = P00GB2_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = P00GB2_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = P00GB2_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = P00GB2_A138ConAFIPRegEspApo[0] ;
         A380ConAFIPTipo = P00GB2_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = P00GB2_A381ConAfipSubT1[0] ;
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto( A386ConAFIPConcepto );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo( A141ConAFIPSIPAApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont( A142ConAFIPSIPACont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo( A131ConAFIPINSSJyPApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont( A132ConAFIPINSSJyPCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo( A135ConAFIPObraSocApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont( A136ConAFIPObraSocCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo( A129ConAFIPFonSolRedApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont( A130ConAFIPFonSolRedCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo( A139ConAFIPRenateaApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont( A140ConAFIPRenateaCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont( A127ConAFIPAsigFamCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont( A128ConAFIPFonNacEmpCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont( A133ConAFIPLeyRieTrabCont );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo( A137ConAFIPRegDifApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo( A138ConAFIPRegEspApo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo( A380ConAFIPTipo );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1( A381ConAfipSubT1 );
         AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto( A386ConAFIPConcepto );
         GXt_boolean1 = AV11existeAfipConcepto ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.existeafipconcepto(remoteHandle, context).execute( AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto(), GXv_boolean2) ;
         cargarpasowizardconcepto.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV11existeAfipConcepto = GXt_boolean1 ;
         if ( ! AV11existeAfipConcepto )
         {
            if ( ! (GXutil.strcmp("", AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto())==0) )
            {
               AV15Libre = GXutil.trim( AV9ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto()) ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = cargarpasowizardconcepto.this.AV9ConceptosAfipWizardData;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConceptosAfipWizardData = new web.SdtConceptosAfipWizardData(remoteHandle, context);
      scmdbuf = "" ;
      P00GB2_A73ConCodPropio = new String[] {""} ;
      P00GB2_A3CliCod = new int[1] ;
      P00GB2_A386ConAFIPConcepto = new String[] {""} ;
      P00GB2_n386ConAFIPConcepto = new boolean[] {false} ;
      P00GB2_A141ConAFIPSIPAApo = new String[] {""} ;
      P00GB2_A142ConAFIPSIPACont = new String[] {""} ;
      P00GB2_A131ConAFIPINSSJyPApo = new String[] {""} ;
      P00GB2_A132ConAFIPINSSJyPCont = new String[] {""} ;
      P00GB2_A135ConAFIPObraSocApo = new String[] {""} ;
      P00GB2_A136ConAFIPObraSocCont = new String[] {""} ;
      P00GB2_A129ConAFIPFonSolRedApo = new String[] {""} ;
      P00GB2_A130ConAFIPFonSolRedCont = new String[] {""} ;
      P00GB2_A139ConAFIPRenateaApo = new String[] {""} ;
      P00GB2_A140ConAFIPRenateaCont = new String[] {""} ;
      P00GB2_A127ConAFIPAsigFamCont = new String[] {""} ;
      P00GB2_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      P00GB2_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      P00GB2_A137ConAFIPRegDifApo = new String[] {""} ;
      P00GB2_A138ConAFIPRegEspApo = new String[] {""} ;
      P00GB2_A380ConAFIPTipo = new String[] {""} ;
      P00GB2_A381ConAfipSubT1 = new String[] {""} ;
      A73ConCodPropio = "" ;
      A386ConAFIPConcepto = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      A380ConAFIPTipo = "" ;
      A381ConAfipSubT1 = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV15Libre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cargarpasowizardconcepto__default(),
         new Object[] {
             new Object[] {
            P00GB2_A73ConCodPropio, P00GB2_A3CliCod, P00GB2_A386ConAFIPConcepto, P00GB2_n386ConAFIPConcepto, P00GB2_A141ConAFIPSIPAApo, P00GB2_A142ConAFIPSIPACont, P00GB2_A131ConAFIPINSSJyPApo, P00GB2_A132ConAFIPINSSJyPCont, P00GB2_A135ConAFIPObraSocApo, P00GB2_A136ConAFIPObraSocCont,
            P00GB2_A129ConAFIPFonSolRedApo, P00GB2_A130ConAFIPFonSolRedCont, P00GB2_A139ConAFIPRenateaApo, P00GB2_A140ConAFIPRenateaCont, P00GB2_A127ConAFIPAsigFamCont, P00GB2_A128ConAFIPFonNacEmpCont, P00GB2_A133ConAFIPLeyRieTrabCont, P00GB2_A137ConAFIPRegDifApo, P00GB2_A138ConAFIPRegEspApo, P00GB2_A380ConAFIPTipo,
            P00GB2_A381ConAfipSubT1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private String AV10ConCodPropio ;
   private String scmdbuf ;
   private String A73ConCodPropio ;
   private String A386ConAFIPConcepto ;
   private String A141ConAFIPSIPAApo ;
   private String A142ConAFIPSIPACont ;
   private String A131ConAFIPINSSJyPApo ;
   private String A132ConAFIPINSSJyPCont ;
   private String A135ConAFIPObraSocApo ;
   private String A136ConAFIPObraSocCont ;
   private String A129ConAFIPFonSolRedApo ;
   private String A130ConAFIPFonSolRedCont ;
   private String A139ConAFIPRenateaApo ;
   private String A140ConAFIPRenateaCont ;
   private String A127ConAFIPAsigFamCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String A137ConAFIPRegDifApo ;
   private String A138ConAFIPRegEspApo ;
   private String A380ConAFIPTipo ;
   private String A381ConAfipSubT1 ;
   private String AV15Libre ;
   private boolean n386ConAFIPConcepto ;
   private boolean AV11existeAfipConcepto ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private web.SdtConceptosAfipWizardData[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00GB2_A73ConCodPropio ;
   private int[] P00GB2_A3CliCod ;
   private String[] P00GB2_A386ConAFIPConcepto ;
   private boolean[] P00GB2_n386ConAFIPConcepto ;
   private String[] P00GB2_A141ConAFIPSIPAApo ;
   private String[] P00GB2_A142ConAFIPSIPACont ;
   private String[] P00GB2_A131ConAFIPINSSJyPApo ;
   private String[] P00GB2_A132ConAFIPINSSJyPCont ;
   private String[] P00GB2_A135ConAFIPObraSocApo ;
   private String[] P00GB2_A136ConAFIPObraSocCont ;
   private String[] P00GB2_A129ConAFIPFonSolRedApo ;
   private String[] P00GB2_A130ConAFIPFonSolRedCont ;
   private String[] P00GB2_A139ConAFIPRenateaApo ;
   private String[] P00GB2_A140ConAFIPRenateaCont ;
   private String[] P00GB2_A127ConAFIPAsigFamCont ;
   private String[] P00GB2_A128ConAFIPFonNacEmpCont ;
   private String[] P00GB2_A133ConAFIPLeyRieTrabCont ;
   private String[] P00GB2_A137ConAFIPRegDifApo ;
   private String[] P00GB2_A138ConAFIPRegEspApo ;
   private String[] P00GB2_A380ConAFIPTipo ;
   private String[] P00GB2_A381ConAfipSubT1 ;
   private web.SdtConceptosAfipWizardData AV9ConceptosAfipWizardData ;
}

final  class cargarpasowizardconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GB2", "SELECT ConCodPropio, CliCod, ConAFIPConcepto, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAFIPTipo, ConAfipSubT1 FROM ConceptoAFIP WHERE CliCod = ? and ConCodPropio = ( ?) ORDER BY CliCod, ConCodPropio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 20);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
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
      }
   }

}

