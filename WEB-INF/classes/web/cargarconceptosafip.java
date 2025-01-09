package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cargarconceptosafip extends GXProcedure
{
   public cargarconceptosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cargarconceptosafip.class ), "" );
   }

   public cargarconceptosafip( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem> executeUdp( int aP0 )
   {
      cargarconceptosafip.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>[] aP1 )
   {
      cargarconceptosafip.this.AV8clicod = aP0;
      cargarconceptosafip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00G02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A386ConAFIPConcepto = P00G02_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = P00G02_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = P00G02_A134ConAFIPMarcaRep[0] ;
         A141ConAFIPSIPAApo = P00G02_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = P00G02_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = P00G02_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = P00G02_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = P00G02_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = P00G02_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = P00G02_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = P00G02_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = P00G02_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = P00G02_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = P00G02_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = P00G02_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = P00G02_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = P00G02_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = P00G02_A138ConAFIPRegEspApo[0] ;
         A379ConAfipEstado = P00G02_A379ConAfipEstado[0] ;
         A380ConAFIPTipo = P00G02_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = P00G02_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = P00G02_A382ConAfipSubT2[0] ;
         A383ConAfipDesc = P00G02_A383ConAfipDesc[0] ;
         A73ConCodPropio = P00G02_A73ConCodPropio[0] ;
         A3CliCod = P00G02_A3CliCod[0] ;
         GXt_char1 = A391ConAfipSubT2Def ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char2) ;
         cargarconceptosafip.this.GXt_char1 = GXv_char2[0] ;
         A391ConAfipSubT2Def = GXt_char1 ;
         GXt_char1 = A390ConAfipSubT1Def ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char2) ;
         cargarconceptosafip.this.GXt_char1 = GXv_char2[0] ;
         A390ConAfipSubT1Def = GXt_char1 ;
         GXt_char1 = A389ConAFIPTipoDef ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char2) ;
         cargarconceptosafip.this.GXt_char1 = GXv_char2[0] ;
         A389ConAFIPTipoDef = GXt_char1 ;
         AV10item = (web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)new web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem(remoteHandle, context);
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio( A73ConCodPropio );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto( A386ConAFIPConcepto );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep( A134ConAFIPMarcaRep );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo( A141ConAFIPSIPAApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont( A142ConAFIPSIPACont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo( A131ConAFIPINSSJyPApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont( A132ConAFIPINSSJyPCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo( A135ConAFIPObraSocApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont( A136ConAFIPObraSocCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo( A129ConAFIPFonSolRedApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont( A130ConAFIPFonSolRedCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo( A139ConAFIPRenateaApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont( A140ConAFIPRenateaCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont( A127ConAFIPAsigFamCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont( A128ConAFIPFonNacEmpCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont( A133ConAFIPLeyRieTrabCont );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo( A137ConAFIPRegDifApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo( A138ConAFIPRegEspApo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado( A379ConAfipEstado );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo( A380ConAFIPTipo );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1( A381ConAfipSubT1 );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2( A382ConAfipSubT2 );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc( A383ConAfipDesc );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef( A389ConAFIPTipoDef );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def( A390ConAfipSubT1Def );
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def( A391ConAfipSubT2Def );
         GXt_int3 = AV11conorden ;
         GXv_int4[0] = GXt_int3 ;
         new web.getordenconcepto(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_int4) ;
         cargarconceptosafip.this.GXt_int3 = GXv_int4[0] ;
         AV11conorden = GXt_int3 ;
         AV10item.setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden( AV11conorden );
         AV9sdt_conceptos_afip.add(AV10item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = cargarconceptosafip.this.AV9sdt_conceptos_afip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9sdt_conceptos_afip = new GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>(web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem.class, "sdt_conceptos_afipItem", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P00G02_A386ConAFIPConcepto = new String[] {""} ;
      P00G02_n386ConAFIPConcepto = new boolean[] {false} ;
      P00G02_A134ConAFIPMarcaRep = new String[] {""} ;
      P00G02_A141ConAFIPSIPAApo = new String[] {""} ;
      P00G02_A142ConAFIPSIPACont = new String[] {""} ;
      P00G02_A131ConAFIPINSSJyPApo = new String[] {""} ;
      P00G02_A132ConAFIPINSSJyPCont = new String[] {""} ;
      P00G02_A135ConAFIPObraSocApo = new String[] {""} ;
      P00G02_A136ConAFIPObraSocCont = new String[] {""} ;
      P00G02_A129ConAFIPFonSolRedApo = new String[] {""} ;
      P00G02_A130ConAFIPFonSolRedCont = new String[] {""} ;
      P00G02_A139ConAFIPRenateaApo = new String[] {""} ;
      P00G02_A140ConAFIPRenateaCont = new String[] {""} ;
      P00G02_A127ConAFIPAsigFamCont = new String[] {""} ;
      P00G02_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      P00G02_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      P00G02_A137ConAFIPRegDifApo = new String[] {""} ;
      P00G02_A138ConAFIPRegEspApo = new String[] {""} ;
      P00G02_A379ConAfipEstado = new String[] {""} ;
      P00G02_A380ConAFIPTipo = new String[] {""} ;
      P00G02_A381ConAfipSubT1 = new String[] {""} ;
      P00G02_A382ConAfipSubT2 = new String[] {""} ;
      P00G02_A383ConAfipDesc = new String[] {""} ;
      P00G02_A73ConCodPropio = new String[] {""} ;
      P00G02_A3CliCod = new int[1] ;
      A386ConAFIPConcepto = "" ;
      A134ConAFIPMarcaRep = "" ;
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
      A379ConAfipEstado = "" ;
      A380ConAFIPTipo = "" ;
      A381ConAfipSubT1 = "" ;
      A382ConAfipSubT2 = "" ;
      A383ConAfipDesc = "" ;
      A73ConCodPropio = "" ;
      A391ConAfipSubT2Def = "" ;
      A390ConAfipSubT1Def = "" ;
      A389ConAFIPTipoDef = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV10item = new web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem(remoteHandle, context);
      GXv_int4 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cargarconceptosafip__default(),
         new Object[] {
             new Object[] {
            P00G02_A386ConAFIPConcepto, P00G02_n386ConAFIPConcepto, P00G02_A134ConAFIPMarcaRep, P00G02_A141ConAFIPSIPAApo, P00G02_A142ConAFIPSIPACont, P00G02_A131ConAFIPINSSJyPApo, P00G02_A132ConAFIPINSSJyPCont, P00G02_A135ConAFIPObraSocApo, P00G02_A136ConAFIPObraSocCont, P00G02_A129ConAFIPFonSolRedApo,
            P00G02_A130ConAFIPFonSolRedCont, P00G02_A139ConAFIPRenateaApo, P00G02_A140ConAFIPRenateaCont, P00G02_A127ConAFIPAsigFamCont, P00G02_A128ConAFIPFonNacEmpCont, P00G02_A133ConAFIPLeyRieTrabCont, P00G02_A137ConAFIPRegDifApo, P00G02_A138ConAFIPRegEspApo, P00G02_A379ConAfipEstado, P00G02_A380ConAFIPTipo,
            P00G02_A381ConAfipSubT1, P00G02_A382ConAfipSubT2, P00G02_A383ConAfipDesc, P00G02_A73ConCodPropio, P00G02_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private int AV11conorden ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private String scmdbuf ;
   private String A386ConAFIPConcepto ;
   private String A134ConAFIPMarcaRep ;
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
   private String A379ConAfipEstado ;
   private String A380ConAFIPTipo ;
   private String A381ConAfipSubT1 ;
   private String A382ConAfipSubT2 ;
   private String A73ConCodPropio ;
   private String A391ConAfipSubT2Def ;
   private String A390ConAfipSubT1Def ;
   private String A389ConAFIPTipoDef ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean n386ConAFIPConcepto ;
   private String A383ConAfipDesc ;
   private GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00G02_A386ConAFIPConcepto ;
   private boolean[] P00G02_n386ConAFIPConcepto ;
   private String[] P00G02_A134ConAFIPMarcaRep ;
   private String[] P00G02_A141ConAFIPSIPAApo ;
   private String[] P00G02_A142ConAFIPSIPACont ;
   private String[] P00G02_A131ConAFIPINSSJyPApo ;
   private String[] P00G02_A132ConAFIPINSSJyPCont ;
   private String[] P00G02_A135ConAFIPObraSocApo ;
   private String[] P00G02_A136ConAFIPObraSocCont ;
   private String[] P00G02_A129ConAFIPFonSolRedApo ;
   private String[] P00G02_A130ConAFIPFonSolRedCont ;
   private String[] P00G02_A139ConAFIPRenateaApo ;
   private String[] P00G02_A140ConAFIPRenateaCont ;
   private String[] P00G02_A127ConAFIPAsigFamCont ;
   private String[] P00G02_A128ConAFIPFonNacEmpCont ;
   private String[] P00G02_A133ConAFIPLeyRieTrabCont ;
   private String[] P00G02_A137ConAFIPRegDifApo ;
   private String[] P00G02_A138ConAFIPRegEspApo ;
   private String[] P00G02_A379ConAfipEstado ;
   private String[] P00G02_A380ConAFIPTipo ;
   private String[] P00G02_A381ConAfipSubT1 ;
   private String[] P00G02_A382ConAfipSubT2 ;
   private String[] P00G02_A383ConAfipDesc ;
   private String[] P00G02_A73ConCodPropio ;
   private int[] P00G02_A3CliCod ;
   private GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem> AV9sdt_conceptos_afip ;
   private web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem AV10item ;
}

final  class cargarconceptosafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00G02", "SELECT ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAfipDesc, ConCodPropio, CliCod FROM ConceptoAFIP WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
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
               ((String[]) buf[18])[0] = rslt.getString(18, 20);
               ((String[]) buf[19])[0] = rslt.getString(19, 20);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getVarchar(22);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((int[]) buf[24])[0] = rslt.getInt(24);
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
      }
   }

}

