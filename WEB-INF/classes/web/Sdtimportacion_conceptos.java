package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_conceptos extends GxSilentTrnSdt
{
   public Sdtimportacion_conceptos( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_conceptos.class));
   }

   public Sdtimportacion_conceptos( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_conceptos");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_conceptos( int remoteHandle ,
                                    StructSdtimportacion_conceptos struct )
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
                     short AV1EmpCod ,
                     short AV88ImpLiqSec ,
                     String AV89ImpLiqConExtCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Short.valueOf(AV88ImpLiqSec),AV89ImpLiqConExtCod});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"ImpLiqSec", short.class}, new Object[]{"ImpLiqConExtCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_conceptos");
      metadata.set("BT", "importacion_conceptos");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\",\"ImpLiqConExtCod\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtimportacion_conceptos_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_conceptos_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtCod") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConError") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconerror = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConWarning") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconwarning = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtDescrip") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtDesSinAc") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextdessinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConSisCod") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconsiscod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConAfipCod") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconafipcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqAfipCodMasDesc") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSIPAApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsipaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSIPACont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsipacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqINSSJyPApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqinssjypapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqINSSJyPCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqinssjypcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqObraSocApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqobrasocapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqObraSocCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqobrasoccont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonSolRedApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonSolRedCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRenateaApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqrenateaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRenateaCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqrenateacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqAsigFamCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqasigfamcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonNacEmpCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLeyRieTrabCont") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRegDifApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqregdifapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRegEspApo") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqregespapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtCodYDescrip") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConSisCodYDescrip") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqTipoConCod") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqtipoconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_conceptos_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_conceptos_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConError_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconerror_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConWarning_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtDescrip_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtDesSinAc_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConSisCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConAfipCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqAfipCodMasDesc_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSIPAApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSIPACont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqINSSJyPApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqINSSJyPCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqObraSocApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqObraSocCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonSolRedApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonSolRedCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRenateaApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRenateaCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqAsigFamCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFonNacEmpCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLeyRieTrabCont_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRegDifApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqRegEspApo_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtCodYDescrip_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConSisCodYDescrip_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqTipoConCod_Z") )
            {
               gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z = oReader.getValue() ;
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
         sName = "importacion_conceptos" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Impliqsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConExtCod", gxTv_Sdtimportacion_conceptos_Impliqconextcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConError", gxTv_Sdtimportacion_conceptos_Impliqconerror);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConWarning", gxTv_Sdtimportacion_conceptos_Impliqconwarning);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConExtDescrip", gxTv_Sdtimportacion_conceptos_Impliqconextdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConExtDesSinAc", gxTv_Sdtimportacion_conceptos_Impliqconextdessinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConSisCod", gxTv_Sdtimportacion_conceptos_Impliqconsiscod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConAfipCod", gxTv_Sdtimportacion_conceptos_Impliqconafipcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqAfipCodMasDesc", gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSIPAApo", gxTv_Sdtimportacion_conceptos_Impliqsipaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSIPACont", gxTv_Sdtimportacion_conceptos_Impliqsipacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqINSSJyPApo", gxTv_Sdtimportacion_conceptos_Impliqinssjypapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqINSSJyPCont", gxTv_Sdtimportacion_conceptos_Impliqinssjypcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqObraSocApo", gxTv_Sdtimportacion_conceptos_Impliqobrasocapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqObraSocCont", gxTv_Sdtimportacion_conceptos_Impliqobrasoccont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqFonSolRedApo", gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqFonSolRedCont", gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqRenateaApo", gxTv_Sdtimportacion_conceptos_Impliqrenateaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqRenateaCont", gxTv_Sdtimportacion_conceptos_Impliqrenateacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqAsigFamCont", gxTv_Sdtimportacion_conceptos_Impliqasigfamcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqFonNacEmpCont", gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLeyRieTrabCont", gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqRegDifApo", gxTv_Sdtimportacion_conceptos_Impliqregdifapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqRegEspApo", gxTv_Sdtimportacion_conceptos_Impliqregespapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConExtCodYDescrip", gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConSisCodYDescrip", gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqTipoConCod", gxTv_Sdtimportacion_conceptos_Impliqtipoconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_conceptos_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_conceptos_Impliqsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConExtCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConError_Z", gxTv_Sdtimportacion_conceptos_Impliqconerror_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConWarning_Z", gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConExtDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConExtDesSinAc_Z", gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConSisCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConAfipCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqAfipCodMasDesc_Z", gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSIPAApo_Z", gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSIPACont_Z", gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqINSSJyPApo_Z", gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqINSSJyPCont_Z", gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqObraSocApo_Z", gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqObraSocCont_Z", gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqFonSolRedApo_Z", gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqFonSolRedCont_Z", gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqRenateaApo_Z", gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqRenateaCont_Z", gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqAsigFamCont_Z", gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqFonNacEmpCont_Z", gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqLeyRieTrabCont_Z", gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqRegDifApo_Z", gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqRegEspApo_Z", gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConExtCodYDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConSisCodYDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqTipoConCod_Z", gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_conceptos_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_conceptos_Empcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSec", gxTv_Sdtimportacion_conceptos_Impliqsec, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConExtCod", gxTv_Sdtimportacion_conceptos_Impliqconextcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConError", gxTv_Sdtimportacion_conceptos_Impliqconerror, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConWarning", gxTv_Sdtimportacion_conceptos_Impliqconwarning, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConExtDescrip", gxTv_Sdtimportacion_conceptos_Impliqconextdescrip, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConExtDesSinAc", gxTv_Sdtimportacion_conceptos_Impliqconextdessinac, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConSisCod", gxTv_Sdtimportacion_conceptos_Impliqconsiscod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConAfipCod", gxTv_Sdtimportacion_conceptos_Impliqconafipcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqAfipCodMasDesc", gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSIPAApo", gxTv_Sdtimportacion_conceptos_Impliqsipaapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSIPACont", gxTv_Sdtimportacion_conceptos_Impliqsipacont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqINSSJyPApo", gxTv_Sdtimportacion_conceptos_Impliqinssjypapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqINSSJyPCont", gxTv_Sdtimportacion_conceptos_Impliqinssjypcont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqObraSocApo", gxTv_Sdtimportacion_conceptos_Impliqobrasocapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqObraSocCont", gxTv_Sdtimportacion_conceptos_Impliqobrasoccont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqFonSolRedApo", gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqFonSolRedCont", gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqRenateaApo", gxTv_Sdtimportacion_conceptos_Impliqrenateaapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqRenateaCont", gxTv_Sdtimportacion_conceptos_Impliqrenateacont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqAsigFamCont", gxTv_Sdtimportacion_conceptos_Impliqasigfamcont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqFonNacEmpCont", gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLeyRieTrabCont", gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont, false, includeNonInitialized);
      AddObjectProperty("ImpLiqRegDifApo", gxTv_Sdtimportacion_conceptos_Impliqregdifapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqRegEspApo", gxTv_Sdtimportacion_conceptos_Impliqregespapo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConExtCodYDescrip", gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConSisCodYDescrip", gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip, false, includeNonInitialized);
      AddObjectProperty("ImpLiqTipoConCod", gxTv_Sdtimportacion_conceptos_Impliqtipoconcod, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_conceptos_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_conceptos_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_conceptos_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_conceptos_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSec_Z", gxTv_Sdtimportacion_conceptos_Impliqsec_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConExtCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConError_Z", gxTv_Sdtimportacion_conceptos_Impliqconerror_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConWarning_Z", gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConExtDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConExtDesSinAc_Z", gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConSisCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConAfipCod_Z", gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqAfipCodMasDesc_Z", gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSIPAApo_Z", gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSIPACont_Z", gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqINSSJyPApo_Z", gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqINSSJyPCont_Z", gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqObraSocApo_Z", gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqObraSocCont_Z", gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqFonSolRedApo_Z", gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqFonSolRedCont_Z", gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqRenateaApo_Z", gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqRenateaCont_Z", gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqAsigFamCont_Z", gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqFonNacEmpCont_Z", gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqLeyRieTrabCont_Z", gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqRegDifApo_Z", gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqRegEspApo_Z", gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConExtCodYDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConSisCodYDescrip_Z", gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqTipoConCod_Z", gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_conceptos sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Clicod = sdt.getgxTv_Sdtimportacion_conceptos_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Empcod = sdt.getgxTv_Sdtimportacion_conceptos_Empcod() ;
      }
      if ( sdt.IsDirty("ImpLiqSec") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqsec = sdt.getgxTv_Sdtimportacion_conceptos_Impliqsec() ;
      }
      if ( sdt.IsDirty("ImpLiqConExtCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconextcod = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconextcod() ;
      }
      if ( sdt.IsDirty("ImpLiqConError") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconerror = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconerror() ;
      }
      if ( sdt.IsDirty("ImpLiqConWarning") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconwarning = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconwarning() ;
      }
      if ( sdt.IsDirty("ImpLiqConExtDescrip") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconextdescrip = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip() ;
      }
      if ( sdt.IsDirty("ImpLiqConExtDesSinAc") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconextdessinac = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac() ;
      }
      if ( sdt.IsDirty("ImpLiqConSisCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconsiscod = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconsiscod() ;
      }
      if ( sdt.IsDirty("ImpLiqConAfipCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconafipcod = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconafipcod() ;
      }
      if ( sdt.IsDirty("ImpLiqAfipCodMasDesc") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc = sdt.getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc() ;
      }
      if ( sdt.IsDirty("ImpLiqSIPAApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqsipaapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqsipaapo() ;
      }
      if ( sdt.IsDirty("ImpLiqSIPACont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqsipacont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqsipacont() ;
      }
      if ( sdt.IsDirty("ImpLiqINSSJyPApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqinssjypapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo() ;
      }
      if ( sdt.IsDirty("ImpLiqINSSJyPCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqinssjypcont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont() ;
      }
      if ( sdt.IsDirty("ImpLiqObraSocApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqobrasocapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo() ;
      }
      if ( sdt.IsDirty("ImpLiqObraSocCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqobrasoccont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont() ;
      }
      if ( sdt.IsDirty("ImpLiqFonSolRedApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo() ;
      }
      if ( sdt.IsDirty("ImpLiqFonSolRedCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont() ;
      }
      if ( sdt.IsDirty("ImpLiqRenateaApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqrenateaapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo() ;
      }
      if ( sdt.IsDirty("ImpLiqRenateaCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqrenateacont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqrenateacont() ;
      }
      if ( sdt.IsDirty("ImpLiqAsigFamCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqasigfamcont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont() ;
      }
      if ( sdt.IsDirty("ImpLiqFonNacEmpCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont() ;
      }
      if ( sdt.IsDirty("ImpLiqLeyRieTrabCont") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont = sdt.getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont() ;
      }
      if ( sdt.IsDirty("ImpLiqRegDifApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqregdifapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqregdifapo() ;
      }
      if ( sdt.IsDirty("ImpLiqRegEspApo") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqregespapo = sdt.getgxTv_Sdtimportacion_conceptos_Impliqregespapo() ;
      }
      if ( sdt.IsDirty("ImpLiqConExtCodYDescrip") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip() ;
      }
      if ( sdt.IsDirty("ImpLiqConSisCodYDescrip") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip = sdt.getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip() ;
      }
      if ( sdt.IsDirty("ImpLiqTipoConCod") )
      {
         gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
         gxTv_Sdtimportacion_conceptos_Impliqtipoconcod = sdt.getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod() ;
      }
   }

   public int getgxTv_Sdtimportacion_conceptos_Clicod( )
   {
      return gxTv_Sdtimportacion_conceptos_Clicod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Clicod( int value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_conceptos_Clicod != value )
      {
         gxTv_Sdtimportacion_conceptos_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_conceptos_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_conceptos_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_conceptos_Empcod( )
   {
      return gxTv_Sdtimportacion_conceptos_Empcod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Empcod( short value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_conceptos_Empcod != value )
      {
         gxTv_Sdtimportacion_conceptos_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_conceptos_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_conceptos_Empcod = value ;
   }

   public short getgxTv_Sdtimportacion_conceptos_Impliqsec( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsec ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsec( short value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_conceptos_Impliqsec != value )
      {
         gxTv_Sdtimportacion_conceptos_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_conceptos_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_SetNull( );
      }
      SetDirty("Impliqsec");
      gxTv_Sdtimportacion_conceptos_Impliqsec = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextcod( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextcod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcod( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_Sdtimportacion_conceptos_Impliqconextcod, value) != 0 )
      {
         gxTv_Sdtimportacion_conceptos_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_conceptos_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_SetNull( );
      }
      SetDirty("Impliqconextcod");
      gxTv_Sdtimportacion_conceptos_Impliqconextcod = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconerror( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconerror ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconerror( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconerror");
      gxTv_Sdtimportacion_conceptos_Impliqconerror = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconwarning( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconwarning ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconwarning( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconwarning");
      gxTv_Sdtimportacion_conceptos_Impliqconwarning = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextdescrip ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextdescrip");
      gxTv_Sdtimportacion_conceptos_Impliqconextdescrip = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextdessinac ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextdessinac");
      gxTv_Sdtimportacion_conceptos_Impliqconextdessinac = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconsiscod( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconsiscod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscod( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconsiscod");
      gxTv_Sdtimportacion_conceptos_Impliqconsiscod = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconafipcod( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconafipcod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconafipcod( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconafipcod");
      gxTv_Sdtimportacion_conceptos_Impliqconafipcod = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqafipcodmasdesc");
      gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqsipaapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsipaapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipaapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqsipaapo");
      gxTv_Sdtimportacion_conceptos_Impliqsipaapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqsipacont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsipacont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipacont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqsipacont");
      gxTv_Sdtimportacion_conceptos_Impliqsipacont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqinssjypapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqinssjypapo");
      gxTv_Sdtimportacion_conceptos_Impliqinssjypapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqinssjypcont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqinssjypcont");
      gxTv_Sdtimportacion_conceptos_Impliqinssjypcont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqobrasocapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqobrasocapo");
      gxTv_Sdtimportacion_conceptos_Impliqobrasocapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqobrasoccont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqobrasoccont");
      gxTv_Sdtimportacion_conceptos_Impliqobrasoccont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonsolredapo");
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonsolredcont");
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqrenateaapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqrenateaapo");
      gxTv_Sdtimportacion_conceptos_Impliqrenateaapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqrenateacont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqrenateacont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateacont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqrenateacont");
      gxTv_Sdtimportacion_conceptos_Impliqrenateacont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqasigfamcont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqasigfamcont");
      gxTv_Sdtimportacion_conceptos_Impliqasigfamcont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonnacempcont");
      gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqleyrietrabcont");
      gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqregdifapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqregdifapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregdifapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqregdifapo");
      gxTv_Sdtimportacion_conceptos_Impliqregdifapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqregespapo( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqregespapo ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregespapo( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqregespapo");
      gxTv_Sdtimportacion_conceptos_Impliqregespapo = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextcodydescrip");
      gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconsiscodydescrip");
      gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqtipoconcod ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqtipoconcod");
      gxTv_Sdtimportacion_conceptos_Impliqtipoconcod = value ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Mode( )
   {
      return gxTv_Sdtimportacion_conceptos_Mode ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Mode( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_conceptos_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_conceptos_Initialized( )
   {
      return gxTv_Sdtimportacion_conceptos_Initialized ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Initialized( short value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_conceptos_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_conceptos_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_conceptos_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_conceptos_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_conceptos_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_conceptos_Impliqsec_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsec_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsec_Z( short value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqsec_Z");
      gxTv_Sdtimportacion_conceptos_Impliqsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqsec_Z = (short)(0) ;
      SetDirty("Impliqsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextcod_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z = "" ;
      SetDirty("Impliqconextcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconerror_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconerror_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconerror_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconerror_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconerror_Z = "" ;
      SetDirty("Impliqconerror_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconerror_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconwarning_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z = "" ;
      SetDirty("Impliqconwarning_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextdescrip_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z = "" ;
      SetDirty("Impliqconextdescrip_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextdessinac_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z = "" ;
      SetDirty("Impliqconextdessinac_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconsiscod_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z = "" ;
      SetDirty("Impliqconsiscod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconafipcod_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z = "" ;
      SetDirty("Impliqconafipcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqafipcodmasdesc_Z");
      gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z = "" ;
      SetDirty("Impliqafipcodmasdesc_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqsipaapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z = "" ;
      SetDirty("Impliqsipaapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqsipacont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z = "" ;
      SetDirty("Impliqsipacont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqinssjypapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z = "" ;
      SetDirty("Impliqinssjypapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqinssjypcont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z = "" ;
      SetDirty("Impliqinssjypcont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqobrasocapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z = "" ;
      SetDirty("Impliqobrasocapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqobrasoccont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z = "" ;
      SetDirty("Impliqobrasoccont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonsolredapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z = "" ;
      SetDirty("Impliqfonsolredapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonsolredcont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z = "" ;
      SetDirty("Impliqfonsolredcont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqrenateaapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z = "" ;
      SetDirty("Impliqrenateaapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqrenateacont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z = "" ;
      SetDirty("Impliqrenateacont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqasigfamcont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z = "" ;
      SetDirty("Impliqasigfamcont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqfonnacempcont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z = "" ;
      SetDirty("Impliqfonnacempcont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqleyrietrabcont_Z");
      gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z = "" ;
      SetDirty("Impliqleyrietrabcont_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqregdifapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z = "" ;
      SetDirty("Impliqregdifapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqregespapo_Z");
      gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z = "" ;
      SetDirty("Impliqregespapo_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconextcodydescrip_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z = "" ;
      SetDirty("Impliqconextcodydescrip_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqconsiscodydescrip_Z");
      gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z = "" ;
      SetDirty("Impliqconsiscodydescrip_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z( )
   {
      return gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z( String value )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(0) ;
      SetDirty("Impliqtipoconcod_Z");
      gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z = "" ;
      SetDirty("Impliqtipoconcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_conceptos_bc obj;
      obj = new web.importacion_conceptos_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_conceptos_N = (byte)(1) ;
      gxTv_Sdtimportacion_conceptos_Impliqconextcod = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconerror = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconwarning = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextdescrip = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextdessinac = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconsiscod = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconafipcod = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqsipaapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqsipacont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqinssjypapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqinssjypcont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqobrasocapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqobrasoccont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqrenateaapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqrenateacont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqasigfamcont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqregdifapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqregespapo = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqtipoconcod = "" ;
      gxTv_Sdtimportacion_conceptos_Mode = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconerror_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z = "" ;
      gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_conceptos_N ;
   }

   public web.Sdtimportacion_conceptos Clone( )
   {
      web.Sdtimportacion_conceptos sdt;
      web.importacion_conceptos_bc obj;
      sdt = (web.Sdtimportacion_conceptos)(clone()) ;
      obj = (web.importacion_conceptos_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_conceptos struct )
   {
      setgxTv_Sdtimportacion_conceptos_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_conceptos_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_conceptos_Impliqsec(struct.getImpliqsec());
      setgxTv_Sdtimportacion_conceptos_Impliqconextcod(struct.getImpliqconextcod());
      setgxTv_Sdtimportacion_conceptos_Impliqconerror(struct.getImpliqconerror());
      setgxTv_Sdtimportacion_conceptos_Impliqconwarning(struct.getImpliqconwarning());
      setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip(struct.getImpliqconextdescrip());
      setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac(struct.getImpliqconextdessinac());
      setgxTv_Sdtimportacion_conceptos_Impliqconsiscod(struct.getImpliqconsiscod());
      setgxTv_Sdtimportacion_conceptos_Impliqconafipcod(struct.getImpliqconafipcod());
      setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc(struct.getImpliqafipcodmasdesc());
      setgxTv_Sdtimportacion_conceptos_Impliqsipaapo(struct.getImpliqsipaapo());
      setgxTv_Sdtimportacion_conceptos_Impliqsipacont(struct.getImpliqsipacont());
      setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo(struct.getImpliqinssjypapo());
      setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont(struct.getImpliqinssjypcont());
      setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo(struct.getImpliqobrasocapo());
      setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont(struct.getImpliqobrasoccont());
      setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo(struct.getImpliqfonsolredapo());
      setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont(struct.getImpliqfonsolredcont());
      setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo(struct.getImpliqrenateaapo());
      setgxTv_Sdtimportacion_conceptos_Impliqrenateacont(struct.getImpliqrenateacont());
      setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont(struct.getImpliqasigfamcont());
      setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont(struct.getImpliqfonnacempcont());
      setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont(struct.getImpliqleyrietrabcont());
      setgxTv_Sdtimportacion_conceptos_Impliqregdifapo(struct.getImpliqregdifapo());
      setgxTv_Sdtimportacion_conceptos_Impliqregespapo(struct.getImpliqregespapo());
      setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip(struct.getImpliqconextcodydescrip());
      setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip(struct.getImpliqconsiscodydescrip());
      setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod(struct.getImpliqtipoconcod());
      setgxTv_Sdtimportacion_conceptos_Mode(struct.getMode());
      setgxTv_Sdtimportacion_conceptos_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_conceptos_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_conceptos_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqsec_Z(struct.getImpliqsec_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z(struct.getImpliqconextcod_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z(struct.getImpliqconerror_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z(struct.getImpliqconwarning_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z(struct.getImpliqconextdescrip_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z(struct.getImpliqconextdessinac_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z(struct.getImpliqconsiscod_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z(struct.getImpliqconafipcod_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z(struct.getImpliqafipcodmasdesc_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z(struct.getImpliqsipaapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z(struct.getImpliqsipacont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z(struct.getImpliqinssjypapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z(struct.getImpliqinssjypcont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z(struct.getImpliqobrasocapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z(struct.getImpliqobrasoccont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z(struct.getImpliqfonsolredapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z(struct.getImpliqfonsolredcont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z(struct.getImpliqrenateaapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z(struct.getImpliqrenateacont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z(struct.getImpliqasigfamcont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z(struct.getImpliqfonnacempcont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z(struct.getImpliqleyrietrabcont_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z(struct.getImpliqregdifapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z(struct.getImpliqregespapo_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z(struct.getImpliqconextcodydescrip_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z(struct.getImpliqconsiscodydescrip_Z());
      setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z(struct.getImpliqtipoconcod_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_conceptos getStruct( )
   {
      web.StructSdtimportacion_conceptos struct = new web.StructSdtimportacion_conceptos ();
      struct.setClicod(getgxTv_Sdtimportacion_conceptos_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_conceptos_Empcod());
      struct.setImpliqsec(getgxTv_Sdtimportacion_conceptos_Impliqsec());
      struct.setImpliqconextcod(getgxTv_Sdtimportacion_conceptos_Impliqconextcod());
      struct.setImpliqconerror(getgxTv_Sdtimportacion_conceptos_Impliqconerror());
      struct.setImpliqconwarning(getgxTv_Sdtimportacion_conceptos_Impliqconwarning());
      struct.setImpliqconextdescrip(getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip());
      struct.setImpliqconextdessinac(getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac());
      struct.setImpliqconsiscod(getgxTv_Sdtimportacion_conceptos_Impliqconsiscod());
      struct.setImpliqconafipcod(getgxTv_Sdtimportacion_conceptos_Impliqconafipcod());
      struct.setImpliqafipcodmasdesc(getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc());
      struct.setImpliqsipaapo(getgxTv_Sdtimportacion_conceptos_Impliqsipaapo());
      struct.setImpliqsipacont(getgxTv_Sdtimportacion_conceptos_Impliqsipacont());
      struct.setImpliqinssjypapo(getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo());
      struct.setImpliqinssjypcont(getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont());
      struct.setImpliqobrasocapo(getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo());
      struct.setImpliqobrasoccont(getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont());
      struct.setImpliqfonsolredapo(getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo());
      struct.setImpliqfonsolredcont(getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont());
      struct.setImpliqrenateaapo(getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo());
      struct.setImpliqrenateacont(getgxTv_Sdtimportacion_conceptos_Impliqrenateacont());
      struct.setImpliqasigfamcont(getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont());
      struct.setImpliqfonnacempcont(getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont());
      struct.setImpliqleyrietrabcont(getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont());
      struct.setImpliqregdifapo(getgxTv_Sdtimportacion_conceptos_Impliqregdifapo());
      struct.setImpliqregespapo(getgxTv_Sdtimportacion_conceptos_Impliqregespapo());
      struct.setImpliqconextcodydescrip(getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip());
      struct.setImpliqconsiscodydescrip(getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip());
      struct.setImpliqtipoconcod(getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod());
      struct.setMode(getgxTv_Sdtimportacion_conceptos_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_conceptos_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_conceptos_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_conceptos_Empcod_Z());
      struct.setImpliqsec_Z(getgxTv_Sdtimportacion_conceptos_Impliqsec_Z());
      struct.setImpliqconextcod_Z(getgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z());
      struct.setImpliqconerror_Z(getgxTv_Sdtimportacion_conceptos_Impliqconerror_Z());
      struct.setImpliqconwarning_Z(getgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z());
      struct.setImpliqconextdescrip_Z(getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z());
      struct.setImpliqconextdessinac_Z(getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z());
      struct.setImpliqconsiscod_Z(getgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z());
      struct.setImpliqconafipcod_Z(getgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z());
      struct.setImpliqafipcodmasdesc_Z(getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z());
      struct.setImpliqsipaapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z());
      struct.setImpliqsipacont_Z(getgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z());
      struct.setImpliqinssjypapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z());
      struct.setImpliqinssjypcont_Z(getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z());
      struct.setImpliqobrasocapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z());
      struct.setImpliqobrasoccont_Z(getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z());
      struct.setImpliqfonsolredapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z());
      struct.setImpliqfonsolredcont_Z(getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z());
      struct.setImpliqrenateaapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z());
      struct.setImpliqrenateacont_Z(getgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z());
      struct.setImpliqasigfamcont_Z(getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z());
      struct.setImpliqfonnacempcont_Z(getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z());
      struct.setImpliqleyrietrabcont_Z(getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z());
      struct.setImpliqregdifapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z());
      struct.setImpliqregespapo_Z(getgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z());
      struct.setImpliqconextcodydescrip_Z(getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z());
      struct.setImpliqconsiscodydescrip_Z(getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z());
      struct.setImpliqtipoconcod_Z(getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_conceptos_N ;
   private short gxTv_Sdtimportacion_conceptos_Empcod ;
   private short gxTv_Sdtimportacion_conceptos_Impliqsec ;
   private short gxTv_Sdtimportacion_conceptos_Initialized ;
   private short gxTv_Sdtimportacion_conceptos_Empcod_Z ;
   private short gxTv_Sdtimportacion_conceptos_Impliqsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_conceptos_Clicod ;
   private int gxTv_Sdtimportacion_conceptos_Clicod_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextcod ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconsiscod ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconafipcod ;
   private String gxTv_Sdtimportacion_conceptos_Impliqsipaapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqsipacont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqinssjypapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqinssjypcont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqobrasocapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqobrasoccont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqrenateaapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqrenateacont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqasigfamcont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont ;
   private String gxTv_Sdtimportacion_conceptos_Impliqregdifapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqregespapo ;
   private String gxTv_Sdtimportacion_conceptos_Impliqtipoconcod ;
   private String gxTv_Sdtimportacion_conceptos_Mode ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextcod_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqsipacont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqregespapo_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconerror ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconwarning ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextdescrip ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextdessinac ;
   private String gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconerror_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconwarning_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z ;
   private String gxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z ;
}

