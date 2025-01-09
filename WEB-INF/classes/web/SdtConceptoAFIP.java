package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConceptoAFIP extends GxSilentTrnSdt
{
   public SdtConceptoAFIP( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConceptoAFIP.class));
   }

   public SdtConceptoAFIP( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtConceptoAFIP");
      initialize( remoteHandle) ;
   }

   public SdtConceptoAFIP( int remoteHandle ,
                           StructSdtConceptoAFIP struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     String AV73ConCodPropio )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV73ConCodPropio});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"ConCodPropio", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "ConceptoAFIP");
      metadata.set("BT", "ConceptoAFIP");
      metadata.set("PK", "[ \"CliCod\",\"ConCodPropio\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtConceptoAFIP_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodPropio") )
            {
               gxTv_SdtConceptoAFIP_Concodpropio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPConcepto") )
            {
               gxTv_SdtConceptoAFIP_Conafipconcepto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPMarcaRep") )
            {
               gxTv_SdtConceptoAFIP_Conafipmarcarep = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPAApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipsipaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPACont") )
            {
               gxTv_SdtConceptoAFIP_Conafipsipacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipinssjypapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipinssjypcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipobrasocapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipobrasoccont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonsolredapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonsolredcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaApo") )
            {
               gxTv_SdtConceptoAFIP_Conafiprenateaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaCont") )
            {
               gxTv_SdtConceptoAFIP_Conafiprenateacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPAsigFamCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipasigfamcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonNacEmpCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonnacempcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLeyRieTrabCont") )
            {
               gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegDifApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipregdifapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegEspApo") )
            {
               gxTv_SdtConceptoAFIP_Conafipregespapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipEstado") )
            {
               gxTv_SdtConceptoAFIP_Conafipestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipo") )
            {
               gxTv_SdtConceptoAFIP_Conafiptipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipDesc") )
            {
               gxTv_SdtConceptoAFIP_Conafipdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipoDef") )
            {
               gxTv_SdtConceptoAFIP_Conafiptipodef = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1Def") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt1def = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2Def") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt2def = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLiquidado") )
            {
               gxTv_SdtConceptoAFIP_Conafipliquidado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConceptoAFIP_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConceptoAFIP_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtConceptoAFIP_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodPropio_Z") )
            {
               gxTv_SdtConceptoAFIP_Concodpropio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPConcepto_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipconcepto_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPMarcaRep_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPAApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPACont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsipacont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPAsigFamCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonNacEmpCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLeyRieTrabCont_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegDifApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegEspApo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipregespapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipEstado_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipo_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafiptipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt1_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipDesc_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipoDef_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafiptipodef_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1Def_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2Def_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLiquidado_Z") )
            {
               gxTv_SdtConceptoAFIP_Conafipliquidado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPConcepto_N") )
            {
               gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "ConceptoAFIP" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtConceptoAFIP_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodPropio", gxTv_SdtConceptoAFIP_Concodpropio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPConcepto", gxTv_SdtConceptoAFIP_Conafipconcepto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPMarcaRep", gxTv_SdtConceptoAFIP_Conafipmarcarep);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPSIPAApo", gxTv_SdtConceptoAFIP_Conafipsipaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPSIPACont", gxTv_SdtConceptoAFIP_Conafipsipacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPApo", gxTv_SdtConceptoAFIP_Conafipinssjypapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPCont", gxTv_SdtConceptoAFIP_Conafipinssjypcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocApo", gxTv_SdtConceptoAFIP_Conafipobrasocapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocCont", gxTv_SdtConceptoAFIP_Conafipobrasoccont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedApo", gxTv_SdtConceptoAFIP_Conafipfonsolredapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedCont", gxTv_SdtConceptoAFIP_Conafipfonsolredcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaApo", gxTv_SdtConceptoAFIP_Conafiprenateaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaCont", gxTv_SdtConceptoAFIP_Conafiprenateacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPAsigFamCont", gxTv_SdtConceptoAFIP_Conafipasigfamcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonNacEmpCont", gxTv_SdtConceptoAFIP_Conafipfonnacempcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPLeyRieTrabCont", gxTv_SdtConceptoAFIP_Conafipleyrietrabcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegDifApo", gxTv_SdtConceptoAFIP_Conafipregdifapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegEspApo", gxTv_SdtConceptoAFIP_Conafipregespapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipEstado", gxTv_SdtConceptoAFIP_Conafipestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPTipo", gxTv_SdtConceptoAFIP_Conafiptipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT1", gxTv_SdtConceptoAFIP_Conafipsubt1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT2", gxTv_SdtConceptoAFIP_Conafipsubt2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipDesc", gxTv_SdtConceptoAFIP_Conafipdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPTipoDef", gxTv_SdtConceptoAFIP_Conafiptipodef);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT1Def", gxTv_SdtConceptoAFIP_Conafipsubt1def);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT2Def", gxTv_SdtConceptoAFIP_Conafipsubt2def);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPLiquidado", GXutil.booltostr( gxTv_SdtConceptoAFIP_Conafipliquidado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConceptoAFIP_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConceptoAFIP_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtConceptoAFIP_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodPropio_Z", gxTv_SdtConceptoAFIP_Concodpropio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPConcepto_Z", gxTv_SdtConceptoAFIP_Conafipconcepto_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPMarcaRep_Z", gxTv_SdtConceptoAFIP_Conafipmarcarep_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPSIPAApo_Z", gxTv_SdtConceptoAFIP_Conafipsipaapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPSIPACont_Z", gxTv_SdtConceptoAFIP_Conafipsipacont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPINSSJyPApo_Z", gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPINSSJyPCont_Z", gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPObraSocApo_Z", gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPObraSocCont_Z", gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPFonSolRedApo_Z", gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPFonSolRedCont_Z", gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPRenateaApo_Z", gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPRenateaCont_Z", gxTv_SdtConceptoAFIP_Conafiprenateacont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPAsigFamCont_Z", gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPFonNacEmpCont_Z", gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPLeyRieTrabCont_Z", gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPRegDifApo_Z", gxTv_SdtConceptoAFIP_Conafipregdifapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPRegEspApo_Z", gxTv_SdtConceptoAFIP_Conafipregespapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipEstado_Z", gxTv_SdtConceptoAFIP_Conafipestado_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPTipo_Z", gxTv_SdtConceptoAFIP_Conafiptipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipSubT1_Z", gxTv_SdtConceptoAFIP_Conafipsubt1_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipSubT2_Z", gxTv_SdtConceptoAFIP_Conafipsubt2_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipDesc_Z", gxTv_SdtConceptoAFIP_Conafipdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPTipoDef_Z", gxTv_SdtConceptoAFIP_Conafiptipodef_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipSubT1Def_Z", gxTv_SdtConceptoAFIP_Conafipsubt1def_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAfipSubT2Def_Z", gxTv_SdtConceptoAFIP_Conafipsubt2def_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPLiquidado_Z", GXutil.booltostr( gxTv_SdtConceptoAFIP_Conafipliquidado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAFIPConcepto_N", GXutil.trim( GXutil.str( gxTv_SdtConceptoAFIP_Conafipconcepto_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtConceptoAFIP_Clicod, false, includeNonInitialized);
      AddObjectProperty("ConCodPropio", gxTv_SdtConceptoAFIP_Concodpropio, false, includeNonInitialized);
      AddObjectProperty("ConAFIPConcepto", gxTv_SdtConceptoAFIP_Conafipconcepto, false, includeNonInitialized);
      AddObjectProperty("ConAFIPConcepto_N", gxTv_SdtConceptoAFIP_Conafipconcepto_N, false, includeNonInitialized);
      AddObjectProperty("ConAFIPMarcaRep", gxTv_SdtConceptoAFIP_Conafipmarcarep, false, includeNonInitialized);
      AddObjectProperty("ConAFIPSIPAApo", gxTv_SdtConceptoAFIP_Conafipsipaapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPSIPACont", gxTv_SdtConceptoAFIP_Conafipsipacont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPINSSJyPApo", gxTv_SdtConceptoAFIP_Conafipinssjypapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPINSSJyPCont", gxTv_SdtConceptoAFIP_Conafipinssjypcont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPObraSocApo", gxTv_SdtConceptoAFIP_Conafipobrasocapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPObraSocCont", gxTv_SdtConceptoAFIP_Conafipobrasoccont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPFonSolRedApo", gxTv_SdtConceptoAFIP_Conafipfonsolredapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPFonSolRedCont", gxTv_SdtConceptoAFIP_Conafipfonsolredcont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPRenateaApo", gxTv_SdtConceptoAFIP_Conafiprenateaapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPRenateaCont", gxTv_SdtConceptoAFIP_Conafiprenateacont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPAsigFamCont", gxTv_SdtConceptoAFIP_Conafipasigfamcont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPFonNacEmpCont", gxTv_SdtConceptoAFIP_Conafipfonnacempcont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPLeyRieTrabCont", gxTv_SdtConceptoAFIP_Conafipleyrietrabcont, false, includeNonInitialized);
      AddObjectProperty("ConAFIPRegDifApo", gxTv_SdtConceptoAFIP_Conafipregdifapo, false, includeNonInitialized);
      AddObjectProperty("ConAFIPRegEspApo", gxTv_SdtConceptoAFIP_Conafipregespapo, false, includeNonInitialized);
      AddObjectProperty("ConAfipEstado", gxTv_SdtConceptoAFIP_Conafipestado, false, includeNonInitialized);
      AddObjectProperty("ConAFIPTipo", gxTv_SdtConceptoAFIP_Conafiptipo, false, includeNonInitialized);
      AddObjectProperty("ConAfipSubT1", gxTv_SdtConceptoAFIP_Conafipsubt1, false, includeNonInitialized);
      AddObjectProperty("ConAfipSubT2", gxTv_SdtConceptoAFIP_Conafipsubt2, false, includeNonInitialized);
      AddObjectProperty("ConAfipDesc", gxTv_SdtConceptoAFIP_Conafipdesc, false, includeNonInitialized);
      AddObjectProperty("ConAFIPTipoDef", gxTv_SdtConceptoAFIP_Conafiptipodef, false, includeNonInitialized);
      AddObjectProperty("ConAfipSubT1Def", gxTv_SdtConceptoAFIP_Conafipsubt1def, false, includeNonInitialized);
      AddObjectProperty("ConAfipSubT2Def", gxTv_SdtConceptoAFIP_Conafipsubt2def, false, includeNonInitialized);
      AddObjectProperty("ConAFIPLiquidado", gxTv_SdtConceptoAFIP_Conafipliquidado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConceptoAFIP_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConceptoAFIP_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtConceptoAFIP_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodPropio_Z", gxTv_SdtConceptoAFIP_Concodpropio_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPConcepto_Z", gxTv_SdtConceptoAFIP_Conafipconcepto_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPMarcaRep_Z", gxTv_SdtConceptoAFIP_Conafipmarcarep_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPSIPAApo_Z", gxTv_SdtConceptoAFIP_Conafipsipaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPSIPACont_Z", gxTv_SdtConceptoAFIP_Conafipsipacont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPINSSJyPApo_Z", gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPINSSJyPCont_Z", gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPObraSocApo_Z", gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPObraSocCont_Z", gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPFonSolRedApo_Z", gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPFonSolRedCont_Z", gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPRenateaApo_Z", gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPRenateaCont_Z", gxTv_SdtConceptoAFIP_Conafiprenateacont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPAsigFamCont_Z", gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPFonNacEmpCont_Z", gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPLeyRieTrabCont_Z", gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPRegDifApo_Z", gxTv_SdtConceptoAFIP_Conafipregdifapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPRegEspApo_Z", gxTv_SdtConceptoAFIP_Conafipregespapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipEstado_Z", gxTv_SdtConceptoAFIP_Conafipestado_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPTipo_Z", gxTv_SdtConceptoAFIP_Conafiptipo_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipSubT1_Z", gxTv_SdtConceptoAFIP_Conafipsubt1_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipSubT2_Z", gxTv_SdtConceptoAFIP_Conafipsubt2_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipDesc_Z", gxTv_SdtConceptoAFIP_Conafipdesc_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPTipoDef_Z", gxTv_SdtConceptoAFIP_Conafiptipodef_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipSubT1Def_Z", gxTv_SdtConceptoAFIP_Conafipsubt1def_Z, false, includeNonInitialized);
         AddObjectProperty("ConAfipSubT2Def_Z", gxTv_SdtConceptoAFIP_Conafipsubt2def_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPLiquidado_Z", gxTv_SdtConceptoAFIP_Conafipliquidado_Z, false, includeNonInitialized);
         AddObjectProperty("ConAFIPConcepto_N", gxTv_SdtConceptoAFIP_Conafipconcepto_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConceptoAFIP sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Clicod = sdt.getgxTv_SdtConceptoAFIP_Clicod() ;
      }
      if ( sdt.IsDirty("ConCodPropio") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Concodpropio = sdt.getgxTv_SdtConceptoAFIP_Concodpropio() ;
      }
      if ( sdt.IsDirty("ConAFIPConcepto") )
      {
         gxTv_SdtConceptoAFIP_Conafipconcepto_N = sdt.getgxTv_SdtConceptoAFIP_Conafipconcepto_N() ;
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipconcepto = sdt.getgxTv_SdtConceptoAFIP_Conafipconcepto() ;
      }
      if ( sdt.IsDirty("ConAFIPMarcaRep") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipmarcarep = sdt.getgxTv_SdtConceptoAFIP_Conafipmarcarep() ;
      }
      if ( sdt.IsDirty("ConAFIPSIPAApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsipaapo = sdt.getgxTv_SdtConceptoAFIP_Conafipsipaapo() ;
      }
      if ( sdt.IsDirty("ConAFIPSIPACont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsipacont = sdt.getgxTv_SdtConceptoAFIP_Conafipsipacont() ;
      }
      if ( sdt.IsDirty("ConAFIPINSSJyPApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipinssjypapo = sdt.getgxTv_SdtConceptoAFIP_Conafipinssjypapo() ;
      }
      if ( sdt.IsDirty("ConAFIPINSSJyPCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipinssjypcont = sdt.getgxTv_SdtConceptoAFIP_Conafipinssjypcont() ;
      }
      if ( sdt.IsDirty("ConAFIPObraSocApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipobrasocapo = sdt.getgxTv_SdtConceptoAFIP_Conafipobrasocapo() ;
      }
      if ( sdt.IsDirty("ConAFIPObraSocCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipobrasoccont = sdt.getgxTv_SdtConceptoAFIP_Conafipobrasoccont() ;
      }
      if ( sdt.IsDirty("ConAFIPFonSolRedApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipfonsolredapo = sdt.getgxTv_SdtConceptoAFIP_Conafipfonsolredapo() ;
      }
      if ( sdt.IsDirty("ConAFIPFonSolRedCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipfonsolredcont = sdt.getgxTv_SdtConceptoAFIP_Conafipfonsolredcont() ;
      }
      if ( sdt.IsDirty("ConAFIPRenateaApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafiprenateaapo = sdt.getgxTv_SdtConceptoAFIP_Conafiprenateaapo() ;
      }
      if ( sdt.IsDirty("ConAFIPRenateaCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafiprenateacont = sdt.getgxTv_SdtConceptoAFIP_Conafiprenateacont() ;
      }
      if ( sdt.IsDirty("ConAFIPAsigFamCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipasigfamcont = sdt.getgxTv_SdtConceptoAFIP_Conafipasigfamcont() ;
      }
      if ( sdt.IsDirty("ConAFIPFonNacEmpCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipfonnacempcont = sdt.getgxTv_SdtConceptoAFIP_Conafipfonnacempcont() ;
      }
      if ( sdt.IsDirty("ConAFIPLeyRieTrabCont") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = sdt.getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont() ;
      }
      if ( sdt.IsDirty("ConAFIPRegDifApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipregdifapo = sdt.getgxTv_SdtConceptoAFIP_Conafipregdifapo() ;
      }
      if ( sdt.IsDirty("ConAFIPRegEspApo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipregespapo = sdt.getgxTv_SdtConceptoAFIP_Conafipregespapo() ;
      }
      if ( sdt.IsDirty("ConAfipEstado") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipestado = sdt.getgxTv_SdtConceptoAFIP_Conafipestado() ;
      }
      if ( sdt.IsDirty("ConAFIPTipo") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafiptipo = sdt.getgxTv_SdtConceptoAFIP_Conafiptipo() ;
      }
      if ( sdt.IsDirty("ConAfipSubT1") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsubt1 = sdt.getgxTv_SdtConceptoAFIP_Conafipsubt1() ;
      }
      if ( sdt.IsDirty("ConAfipSubT2") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsubt2 = sdt.getgxTv_SdtConceptoAFIP_Conafipsubt2() ;
      }
      if ( sdt.IsDirty("ConAfipDesc") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipdesc = sdt.getgxTv_SdtConceptoAFIP_Conafipdesc() ;
      }
      if ( sdt.IsDirty("ConAFIPTipoDef") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafiptipodef = sdt.getgxTv_SdtConceptoAFIP_Conafiptipodef() ;
      }
      if ( sdt.IsDirty("ConAfipSubT1Def") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsubt1def = sdt.getgxTv_SdtConceptoAFIP_Conafipsubt1def() ;
      }
      if ( sdt.IsDirty("ConAfipSubT2Def") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipsubt2def = sdt.getgxTv_SdtConceptoAFIP_Conafipsubt2def() ;
      }
      if ( sdt.IsDirty("ConAFIPLiquidado") )
      {
         gxTv_SdtConceptoAFIP_N = (byte)(0) ;
         gxTv_SdtConceptoAFIP_Conafipliquidado = sdt.getgxTv_SdtConceptoAFIP_Conafipliquidado() ;
      }
   }

   public int getgxTv_SdtConceptoAFIP_Clicod( )
   {
      return gxTv_SdtConceptoAFIP_Clicod ;
   }

   public void setgxTv_SdtConceptoAFIP_Clicod( int value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      if ( gxTv_SdtConceptoAFIP_Clicod != value )
      {
         gxTv_SdtConceptoAFIP_Mode = "INS" ;
         this.setgxTv_SdtConceptoAFIP_Clicod_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Concodpropio_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipconcepto_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsipacont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipregespapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipestado_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiptipo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt1_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt2_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipdesc_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiptipodef_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipliquidado_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtConceptoAFIP_Clicod = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Concodpropio( )
   {
      return gxTv_SdtConceptoAFIP_Concodpropio ;
   }

   public void setgxTv_SdtConceptoAFIP_Concodpropio( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtConceptoAFIP_Concodpropio, value) != 0 )
      {
         gxTv_SdtConceptoAFIP_Mode = "INS" ;
         this.setgxTv_SdtConceptoAFIP_Clicod_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Concodpropio_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipconcepto_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsipacont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipregespapo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipestado_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiptipo_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt1_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt2_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipdesc_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafiptipodef_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z_SetNull( );
         this.setgxTv_SdtConceptoAFIP_Conafipliquidado_Z_SetNull( );
      }
      SetDirty("Concodpropio");
      gxTv_SdtConceptoAFIP_Concodpropio = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipconcepto( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto( String value )
   {
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipconcepto");
      gxTv_SdtConceptoAFIP_Conafipconcepto = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(1) ;
      gxTv_SdtConceptoAFIP_Conafipconcepto = "" ;
      SetDirty("Conafipconcepto");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipconcepto_IsNull( )
   {
      return (gxTv_SdtConceptoAFIP_Conafipconcepto_N==1) ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipmarcarep( )
   {
      return gxTv_SdtConceptoAFIP_Conafipmarcarep ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipmarcarep( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipmarcarep");
      gxTv_SdtConceptoAFIP_Conafipmarcarep = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsipaapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipaapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipaapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsipaapo");
      gxTv_SdtConceptoAFIP_Conafipsipaapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsipacont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipacont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipacont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsipacont");
      gxTv_SdtConceptoAFIP_Conafipsipacont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipinssjypapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipinssjypapo");
      gxTv_SdtConceptoAFIP_Conafipinssjypapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipinssjypcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypcont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipinssjypcont");
      gxTv_SdtConceptoAFIP_Conafipinssjypcont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipobrasocapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasocapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasocapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipobrasocapo");
      gxTv_SdtConceptoAFIP_Conafipobrasocapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipobrasoccont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasoccont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasoccont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipobrasoccont");
      gxTv_SdtConceptoAFIP_Conafipobrasoccont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonsolredapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonsolredapo");
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonsolredcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredcont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonsolredcont");
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiprenateaapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateaapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateaapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiprenateaapo");
      gxTv_SdtConceptoAFIP_Conafiprenateaapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiprenateacont( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateacont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateacont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiprenateacont");
      gxTv_SdtConceptoAFIP_Conafiprenateacont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipasigfamcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipasigfamcont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipasigfamcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipasigfamcont");
      gxTv_SdtConceptoAFIP_Conafipasigfamcont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonnacempcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonnacempcont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonnacempcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonnacempcont");
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipleyrietrabcont ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipleyrietrabcont");
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipregdifapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregdifapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregdifapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipregdifapo");
      gxTv_SdtConceptoAFIP_Conafipregdifapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipregespapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregespapo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregespapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipregespapo");
      gxTv_SdtConceptoAFIP_Conafipregespapo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipestado( )
   {
      return gxTv_SdtConceptoAFIP_Conafipestado ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipestado( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipestado");
      gxTv_SdtConceptoAFIP_Conafipestado = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiptipo( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipo ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiptipo");
      gxTv_SdtConceptoAFIP_Conafiptipo = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt1( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1 ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt1");
      gxTv_SdtConceptoAFIP_Conafipsubt1 = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt2( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2 ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt2");
      gxTv_SdtConceptoAFIP_Conafipsubt2 = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipdesc( )
   {
      return gxTv_SdtConceptoAFIP_Conafipdesc ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipdesc( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipdesc");
      gxTv_SdtConceptoAFIP_Conafipdesc = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiptipodef( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipodef ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipodef( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiptipodef");
      gxTv_SdtConceptoAFIP_Conafiptipodef = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipodef_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafiptipodef = "" ;
      SetDirty("Conafiptipodef");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafiptipodef_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt1def( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1def ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1def( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt1def");
      gxTv_SdtConceptoAFIP_Conafipsubt1def = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1def_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt1def = "" ;
      SetDirty("Conafipsubt1def");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt1def_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt2def( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2def ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2def( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt2def");
      gxTv_SdtConceptoAFIP_Conafipsubt2def = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2def_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt2def = "" ;
      SetDirty("Conafipsubt2def");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt2def_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipliquidado( )
   {
      return gxTv_SdtConceptoAFIP_Conafipliquidado ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipliquidado( boolean value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipliquidado");
      gxTv_SdtConceptoAFIP_Conafipliquidado = value ;
   }

   public String getgxTv_SdtConceptoAFIP_Mode( )
   {
      return gxTv_SdtConceptoAFIP_Mode ;
   }

   public void setgxTv_SdtConceptoAFIP_Mode( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConceptoAFIP_Mode = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Mode_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConceptoAFIP_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConceptoAFIP_Initialized( )
   {
      return gxTv_SdtConceptoAFIP_Initialized ;
   }

   public void setgxTv_SdtConceptoAFIP_Initialized( short value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtConceptoAFIP_Initialized = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Initialized_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConceptoAFIP_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConceptoAFIP_Clicod_Z( )
   {
      return gxTv_SdtConceptoAFIP_Clicod_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Clicod_Z( int value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtConceptoAFIP_Clicod_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Clicod_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Concodpropio_Z( )
   {
      return gxTv_SdtConceptoAFIP_Concodpropio_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Concodpropio_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Concodpropio_Z");
      gxTv_SdtConceptoAFIP_Concodpropio_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Concodpropio_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Concodpropio_Z = "" ;
      SetDirty("Concodpropio_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Concodpropio_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipconcepto_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipconcepto_Z");
      gxTv_SdtConceptoAFIP_Conafipconcepto_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipconcepto_Z = "" ;
      SetDirty("Conafipconcepto_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipconcepto_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipmarcarep_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipmarcarep_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipmarcarep_Z");
      gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = "" ;
      SetDirty("Conafipmarcarep_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipmarcarep_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsipaapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipaapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsipaapo_Z");
      gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = "" ;
      SetDirty("Conafipsipaapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsipaapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsipacont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipacont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipacont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsipacont_Z");
      gxTv_SdtConceptoAFIP_Conafipsipacont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsipacont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsipacont_Z = "" ;
      SetDirty("Conafipsipacont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsipacont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipinssjypapo_Z");
      gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = "" ;
      SetDirty("Conafipinssjypapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipinssjypcont_Z");
      gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = "" ;
      SetDirty("Conafipinssjypcont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipobrasocapo_Z");
      gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = "" ;
      SetDirty("Conafipobrasocapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipobrasoccont_Z");
      gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = "" ;
      SetDirty("Conafipobrasoccont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonsolredapo_Z");
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = "" ;
      SetDirty("Conafipfonsolredapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonsolredcont_Z");
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = "" ;
      SetDirty("Conafipfonsolredcont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiprenateaapo_Z");
      gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = "" ;
      SetDirty("Conafiprenateaapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiprenateacont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateacont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiprenateacont_Z");
      gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = "" ;
      SetDirty("Conafiprenateacont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafiprenateacont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipasigfamcont_Z");
      gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = "" ;
      SetDirty("Conafipasigfamcont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipfonnacempcont_Z");
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = "" ;
      SetDirty("Conafipfonnacempcont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipleyrietrabcont_Z");
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = "" ;
      SetDirty("Conafipleyrietrabcont_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipregdifapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregdifapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipregdifapo_Z");
      gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = "" ;
      SetDirty("Conafipregdifapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipregdifapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipregespapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregespapo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregespapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipregespapo_Z");
      gxTv_SdtConceptoAFIP_Conafipregespapo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipregespapo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipregespapo_Z = "" ;
      SetDirty("Conafipregespapo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipregespapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipestado_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipestado_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipestado_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipestado_Z");
      gxTv_SdtConceptoAFIP_Conafipestado_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipestado_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipestado_Z = "" ;
      SetDirty("Conafipestado_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiptipo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipo_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiptipo_Z");
      gxTv_SdtConceptoAFIP_Conafiptipo_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipo_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafiptipo_Z = "" ;
      SetDirty("Conafiptipo_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafiptipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt1_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt1_Z");
      gxTv_SdtConceptoAFIP_Conafipsubt1_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt1_Z = "" ;
      SetDirty("Conafipsubt1_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt1_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt2_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt2_Z");
      gxTv_SdtConceptoAFIP_Conafipsubt2_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt2_Z = "" ;
      SetDirty("Conafipsubt2_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt2_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipdesc_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipdesc_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipdesc_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipdesc_Z");
      gxTv_SdtConceptoAFIP_Conafipdesc_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipdesc_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipdesc_Z = "" ;
      SetDirty("Conafipdesc_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipdesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafiptipodef_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipodef_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipodef_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafiptipodef_Z");
      gxTv_SdtConceptoAFIP_Conafiptipodef_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafiptipodef_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafiptipodef_Z = "" ;
      SetDirty("Conafiptipodef_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafiptipodef_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt1def_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1def_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt1def_Z");
      gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = "" ;
      SetDirty("Conafipsubt1def_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt1def_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConceptoAFIP_Conafipsubt2def_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2def_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipsubt2def_Z");
      gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = "" ;
      SetDirty("Conafipsubt2def_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipsubt2def_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipliquidado_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipliquidado_Z ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipliquidado_Z( boolean value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipliquidado_Z");
      gxTv_SdtConceptoAFIP_Conafipliquidado_Z = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipliquidado_Z_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipliquidado_Z = false ;
      SetDirty("Conafipliquidado_Z");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipliquidado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConceptoAFIP_Conafipconcepto_N( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto_N ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto_N( byte value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      SetDirty("Conafipconcepto_N");
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = value ;
   }

   public void setgxTv_SdtConceptoAFIP_Conafipconcepto_N_SetNull( )
   {
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(0) ;
      SetDirty("Conafipconcepto_N");
   }

   public boolean getgxTv_SdtConceptoAFIP_Conafipconcepto_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.conceptoafip_bc obj;
      obj = new web.conceptoafip_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(1) ;
      gxTv_SdtConceptoAFIP_Concodpropio = "" ;
      gxTv_SdtConceptoAFIP_Conafipconcepto = "" ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipacont = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont = "" ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipregespapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipestado = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipo = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1 = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2 = "" ;
      gxTv_SdtConceptoAFIP_Conafipdesc = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipodef = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def = "" ;
      gxTv_SdtConceptoAFIP_Mode = "" ;
      gxTv_SdtConceptoAFIP_Concodpropio_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipconcepto_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipacont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipregespapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipestado_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipdesc_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipodef_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConceptoAFIP_N ;
   }

   public web.SdtConceptoAFIP Clone( )
   {
      web.SdtConceptoAFIP sdt;
      web.conceptoafip_bc obj;
      sdt = (web.SdtConceptoAFIP)(clone()) ;
      obj = (web.conceptoafip_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtConceptoAFIP struct )
   {
      setgxTv_SdtConceptoAFIP_Clicod(struct.getClicod());
      setgxTv_SdtConceptoAFIP_Concodpropio(struct.getConcodpropio());
      setgxTv_SdtConceptoAFIP_Conafipconcepto(struct.getConafipconcepto());
      setgxTv_SdtConceptoAFIP_Conafipmarcarep(struct.getConafipmarcarep());
      setgxTv_SdtConceptoAFIP_Conafipsipaapo(struct.getConafipsipaapo());
      setgxTv_SdtConceptoAFIP_Conafipsipacont(struct.getConafipsipacont());
      setgxTv_SdtConceptoAFIP_Conafipinssjypapo(struct.getConafipinssjypapo());
      setgxTv_SdtConceptoAFIP_Conafipinssjypcont(struct.getConafipinssjypcont());
      setgxTv_SdtConceptoAFIP_Conafipobrasocapo(struct.getConafipobrasocapo());
      setgxTv_SdtConceptoAFIP_Conafipobrasoccont(struct.getConafipobrasoccont());
      setgxTv_SdtConceptoAFIP_Conafipfonsolredapo(struct.getConafipfonsolredapo());
      setgxTv_SdtConceptoAFIP_Conafipfonsolredcont(struct.getConafipfonsolredcont());
      setgxTv_SdtConceptoAFIP_Conafiprenateaapo(struct.getConafiprenateaapo());
      setgxTv_SdtConceptoAFIP_Conafiprenateacont(struct.getConafiprenateacont());
      setgxTv_SdtConceptoAFIP_Conafipasigfamcont(struct.getConafipasigfamcont());
      setgxTv_SdtConceptoAFIP_Conafipfonnacempcont(struct.getConafipfonnacempcont());
      setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont(struct.getConafipleyrietrabcont());
      setgxTv_SdtConceptoAFIP_Conafipregdifapo(struct.getConafipregdifapo());
      setgxTv_SdtConceptoAFIP_Conafipregespapo(struct.getConafipregespapo());
      setgxTv_SdtConceptoAFIP_Conafipestado(struct.getConafipestado());
      setgxTv_SdtConceptoAFIP_Conafiptipo(struct.getConafiptipo());
      setgxTv_SdtConceptoAFIP_Conafipsubt1(struct.getConafipsubt1());
      setgxTv_SdtConceptoAFIP_Conafipsubt2(struct.getConafipsubt2());
      setgxTv_SdtConceptoAFIP_Conafipdesc(struct.getConafipdesc());
      setgxTv_SdtConceptoAFIP_Conafiptipodef(struct.getConafiptipodef());
      setgxTv_SdtConceptoAFIP_Conafipsubt1def(struct.getConafipsubt1def());
      setgxTv_SdtConceptoAFIP_Conafipsubt2def(struct.getConafipsubt2def());
      setgxTv_SdtConceptoAFIP_Conafipliquidado(struct.getConafipliquidado());
      setgxTv_SdtConceptoAFIP_Mode(struct.getMode());
      setgxTv_SdtConceptoAFIP_Initialized(struct.getInitialized());
      setgxTv_SdtConceptoAFIP_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtConceptoAFIP_Concodpropio_Z(struct.getConcodpropio_Z());
      setgxTv_SdtConceptoAFIP_Conafipconcepto_Z(struct.getConafipconcepto_Z());
      setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z(struct.getConafipmarcarep_Z());
      setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z(struct.getConafipsipaapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipsipacont_Z(struct.getConafipsipacont_Z());
      setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z(struct.getConafipinssjypapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z(struct.getConafipinssjypcont_Z());
      setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z(struct.getConafipobrasocapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z(struct.getConafipobrasoccont_Z());
      setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z(struct.getConafipfonsolredapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z(struct.getConafipfonsolredcont_Z());
      setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z(struct.getConafiprenateaapo_Z());
      setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z(struct.getConafiprenateacont_Z());
      setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z(struct.getConafipasigfamcont_Z());
      setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z(struct.getConafipfonnacempcont_Z());
      setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z(struct.getConafipleyrietrabcont_Z());
      setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z(struct.getConafipregdifapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipregespapo_Z(struct.getConafipregespapo_Z());
      setgxTv_SdtConceptoAFIP_Conafipestado_Z(struct.getConafipestado_Z());
      setgxTv_SdtConceptoAFIP_Conafiptipo_Z(struct.getConafiptipo_Z());
      setgxTv_SdtConceptoAFIP_Conafipsubt1_Z(struct.getConafipsubt1_Z());
      setgxTv_SdtConceptoAFIP_Conafipsubt2_Z(struct.getConafipsubt2_Z());
      setgxTv_SdtConceptoAFIP_Conafipdesc_Z(struct.getConafipdesc_Z());
      setgxTv_SdtConceptoAFIP_Conafiptipodef_Z(struct.getConafiptipodef_Z());
      setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z(struct.getConafipsubt1def_Z());
      setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z(struct.getConafipsubt2def_Z());
      setgxTv_SdtConceptoAFIP_Conafipliquidado_Z(struct.getConafipliquidado_Z());
      setgxTv_SdtConceptoAFIP_Conafipconcepto_N(struct.getConafipconcepto_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConceptoAFIP getStruct( )
   {
      web.StructSdtConceptoAFIP struct = new web.StructSdtConceptoAFIP ();
      struct.setClicod(getgxTv_SdtConceptoAFIP_Clicod());
      struct.setConcodpropio(getgxTv_SdtConceptoAFIP_Concodpropio());
      struct.setConafipconcepto(getgxTv_SdtConceptoAFIP_Conafipconcepto());
      struct.setConafipmarcarep(getgxTv_SdtConceptoAFIP_Conafipmarcarep());
      struct.setConafipsipaapo(getgxTv_SdtConceptoAFIP_Conafipsipaapo());
      struct.setConafipsipacont(getgxTv_SdtConceptoAFIP_Conafipsipacont());
      struct.setConafipinssjypapo(getgxTv_SdtConceptoAFIP_Conafipinssjypapo());
      struct.setConafipinssjypcont(getgxTv_SdtConceptoAFIP_Conafipinssjypcont());
      struct.setConafipobrasocapo(getgxTv_SdtConceptoAFIP_Conafipobrasocapo());
      struct.setConafipobrasoccont(getgxTv_SdtConceptoAFIP_Conafipobrasoccont());
      struct.setConafipfonsolredapo(getgxTv_SdtConceptoAFIP_Conafipfonsolredapo());
      struct.setConafipfonsolredcont(getgxTv_SdtConceptoAFIP_Conafipfonsolredcont());
      struct.setConafiprenateaapo(getgxTv_SdtConceptoAFIP_Conafiprenateaapo());
      struct.setConafiprenateacont(getgxTv_SdtConceptoAFIP_Conafiprenateacont());
      struct.setConafipasigfamcont(getgxTv_SdtConceptoAFIP_Conafipasigfamcont());
      struct.setConafipfonnacempcont(getgxTv_SdtConceptoAFIP_Conafipfonnacempcont());
      struct.setConafipleyrietrabcont(getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont());
      struct.setConafipregdifapo(getgxTv_SdtConceptoAFIP_Conafipregdifapo());
      struct.setConafipregespapo(getgxTv_SdtConceptoAFIP_Conafipregespapo());
      struct.setConafipestado(getgxTv_SdtConceptoAFIP_Conafipestado());
      struct.setConafiptipo(getgxTv_SdtConceptoAFIP_Conafiptipo());
      struct.setConafipsubt1(getgxTv_SdtConceptoAFIP_Conafipsubt1());
      struct.setConafipsubt2(getgxTv_SdtConceptoAFIP_Conafipsubt2());
      struct.setConafipdesc(getgxTv_SdtConceptoAFIP_Conafipdesc());
      struct.setConafiptipodef(getgxTv_SdtConceptoAFIP_Conafiptipodef());
      struct.setConafipsubt1def(getgxTv_SdtConceptoAFIP_Conafipsubt1def());
      struct.setConafipsubt2def(getgxTv_SdtConceptoAFIP_Conafipsubt2def());
      struct.setConafipliquidado(getgxTv_SdtConceptoAFIP_Conafipliquidado());
      struct.setMode(getgxTv_SdtConceptoAFIP_Mode());
      struct.setInitialized(getgxTv_SdtConceptoAFIP_Initialized());
      struct.setClicod_Z(getgxTv_SdtConceptoAFIP_Clicod_Z());
      struct.setConcodpropio_Z(getgxTv_SdtConceptoAFIP_Concodpropio_Z());
      struct.setConafipconcepto_Z(getgxTv_SdtConceptoAFIP_Conafipconcepto_Z());
      struct.setConafipmarcarep_Z(getgxTv_SdtConceptoAFIP_Conafipmarcarep_Z());
      struct.setConafipsipaapo_Z(getgxTv_SdtConceptoAFIP_Conafipsipaapo_Z());
      struct.setConafipsipacont_Z(getgxTv_SdtConceptoAFIP_Conafipsipacont_Z());
      struct.setConafipinssjypapo_Z(getgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z());
      struct.setConafipinssjypcont_Z(getgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z());
      struct.setConafipobrasocapo_Z(getgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z());
      struct.setConafipobrasoccont_Z(getgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z());
      struct.setConafipfonsolredapo_Z(getgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z());
      struct.setConafipfonsolredcont_Z(getgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z());
      struct.setConafiprenateaapo_Z(getgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z());
      struct.setConafiprenateacont_Z(getgxTv_SdtConceptoAFIP_Conafiprenateacont_Z());
      struct.setConafipasigfamcont_Z(getgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z());
      struct.setConafipfonnacempcont_Z(getgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z());
      struct.setConafipleyrietrabcont_Z(getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z());
      struct.setConafipregdifapo_Z(getgxTv_SdtConceptoAFIP_Conafipregdifapo_Z());
      struct.setConafipregespapo_Z(getgxTv_SdtConceptoAFIP_Conafipregespapo_Z());
      struct.setConafipestado_Z(getgxTv_SdtConceptoAFIP_Conafipestado_Z());
      struct.setConafiptipo_Z(getgxTv_SdtConceptoAFIP_Conafiptipo_Z());
      struct.setConafipsubt1_Z(getgxTv_SdtConceptoAFIP_Conafipsubt1_Z());
      struct.setConafipsubt2_Z(getgxTv_SdtConceptoAFIP_Conafipsubt2_Z());
      struct.setConafipdesc_Z(getgxTv_SdtConceptoAFIP_Conafipdesc_Z());
      struct.setConafiptipodef_Z(getgxTv_SdtConceptoAFIP_Conafiptipodef_Z());
      struct.setConafipsubt1def_Z(getgxTv_SdtConceptoAFIP_Conafipsubt1def_Z());
      struct.setConafipsubt2def_Z(getgxTv_SdtConceptoAFIP_Conafipsubt2def_Z());
      struct.setConafipliquidado_Z(getgxTv_SdtConceptoAFIP_Conafipliquidado_Z());
      struct.setConafipconcepto_N(getgxTv_SdtConceptoAFIP_Conafipconcepto_N());
      return struct ;
   }

   private byte gxTv_SdtConceptoAFIP_N ;
   private byte gxTv_SdtConceptoAFIP_Conafipconcepto_N ;
   private short gxTv_SdtConceptoAFIP_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtConceptoAFIP_Clicod ;
   private int gxTv_SdtConceptoAFIP_Clicod_Z ;
   private String gxTv_SdtConceptoAFIP_Concodpropio ;
   private String gxTv_SdtConceptoAFIP_Conafipconcepto ;
   private String gxTv_SdtConceptoAFIP_Conafipmarcarep ;
   private String gxTv_SdtConceptoAFIP_Conafipsipaapo ;
   private String gxTv_SdtConceptoAFIP_Conafipsipacont ;
   private String gxTv_SdtConceptoAFIP_Conafipinssjypapo ;
   private String gxTv_SdtConceptoAFIP_Conafipinssjypcont ;
   private String gxTv_SdtConceptoAFIP_Conafipobrasocapo ;
   private String gxTv_SdtConceptoAFIP_Conafipobrasoccont ;
   private String gxTv_SdtConceptoAFIP_Conafipfonsolredapo ;
   private String gxTv_SdtConceptoAFIP_Conafipfonsolredcont ;
   private String gxTv_SdtConceptoAFIP_Conafiprenateaapo ;
   private String gxTv_SdtConceptoAFIP_Conafiprenateacont ;
   private String gxTv_SdtConceptoAFIP_Conafipasigfamcont ;
   private String gxTv_SdtConceptoAFIP_Conafipfonnacempcont ;
   private String gxTv_SdtConceptoAFIP_Conafipleyrietrabcont ;
   private String gxTv_SdtConceptoAFIP_Conafipregdifapo ;
   private String gxTv_SdtConceptoAFIP_Conafipregespapo ;
   private String gxTv_SdtConceptoAFIP_Conafipestado ;
   private String gxTv_SdtConceptoAFIP_Conafiptipo ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt1 ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt2 ;
   private String gxTv_SdtConceptoAFIP_Conafiptipodef ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt1def ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt2def ;
   private String gxTv_SdtConceptoAFIP_Mode ;
   private String gxTv_SdtConceptoAFIP_Concodpropio_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipconcepto_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipmarcarep_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsipaapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsipacont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafiprenateacont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipregdifapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipregespapo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipestado_Z ;
   private String gxTv_SdtConceptoAFIP_Conafiptipo_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt1_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt2_Z ;
   private String gxTv_SdtConceptoAFIP_Conafiptipodef_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt1def_Z ;
   private String gxTv_SdtConceptoAFIP_Conafipsubt2def_Z ;
   private String sTagName ;
   private boolean gxTv_SdtConceptoAFIP_Conafipliquidado ;
   private boolean gxTv_SdtConceptoAFIP_Conafipliquidado_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConceptoAFIP_Conafipdesc ;
   private String gxTv_SdtConceptoAFIP_Conafipdesc_Z ;
}

