package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConceptosAfipWizardData_Concepto1 extends GxUserType
{
   public SdtConceptosAfipWizardData_Concepto1( )
   {
      this(  new ModelContext(SdtConceptosAfipWizardData_Concepto1.class));
   }

   public SdtConceptosAfipWizardData_Concepto1( ModelContext context )
   {
      super( context, "SdtConceptosAfipWizardData_Concepto1");
   }

   public SdtConceptosAfipWizardData_Concepto1( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtConceptosAfipWizardData_Concepto1");
   }

   public SdtConceptosAfipWizardData_Concepto1( StructSdtConceptosAfipWizardData_Concepto1 struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPAApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegDifApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegEspApo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPACont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPAsigFamCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonNacEmpCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLeyRieTrabCont") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPConcepto") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "libre") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Libre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipo") )
            {
               gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo = oReader.getValue() ;
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
         sName = "ConceptosAfipWizardData.Concepto1" ;
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
      oWriter.writeElement("ConAFIPSIPAApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegDifApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegEspApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPSIPACont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPAsigFamCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonNacEmpCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPLeyRieTrabCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT1", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPConcepto", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("libre", gxTv_SdtConceptosAfipWizardData_Concepto1_Libre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPTipo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("ConAFIPSIPAApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo, false, false);
      AddObjectProperty("ConAFIPINSSJyPApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo, false, false);
      AddObjectProperty("ConAFIPObraSocApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo, false, false);
      AddObjectProperty("ConAFIPFonSolRedApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo, false, false);
      AddObjectProperty("ConAFIPRenateaApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo, false, false);
      AddObjectProperty("ConAFIPRegDifApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo, false, false);
      AddObjectProperty("ConAFIPRegEspApo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo, false, false);
      AddObjectProperty("ConAFIPSIPACont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont, false, false);
      AddObjectProperty("ConAFIPINSSJyPCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont, false, false);
      AddObjectProperty("ConAFIPObraSocCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont, false, false);
      AddObjectProperty("ConAFIPFonSolRedCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont, false, false);
      AddObjectProperty("ConAFIPRenateaCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont, false, false);
      AddObjectProperty("ConAFIPAsigFamCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont, false, false);
      AddObjectProperty("ConAFIPFonNacEmpCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont, false, false);
      AddObjectProperty("ConAFIPLeyRieTrabCont", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont, false, false);
      AddObjectProperty("ConAfipSubT1", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1, false, false);
      AddObjectProperty("ConAFIPConcepto", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto, false, false);
      AddObjectProperty("libre", gxTv_SdtConceptosAfipWizardData_Concepto1_Libre, false, false);
      AddObjectProperty("ConAFIPTipo", gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo, false, false);
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1 ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1 = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Libre ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Libre( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Libre = value ;
   }

   public String getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1 = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Libre = "" ;
      gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_N ;
   }

   public web.SdtConceptosAfipWizardData_Concepto1 Clone( )
   {
      return (web.SdtConceptosAfipWizardData_Concepto1)(clone()) ;
   }

   public void setStruct( web.StructSdtConceptosAfipWizardData_Concepto1 struct )
   {
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo(struct.getConafipsipaapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo(struct.getConafipinssjypapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo(struct.getConafipobrasocapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo(struct.getConafipfonsolredapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo(struct.getConafiprenateaapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo(struct.getConafipregdifapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo(struct.getConafipregespapo());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont(struct.getConafipsipacont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont(struct.getConafipinssjypcont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont(struct.getConafipobrasoccont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont(struct.getConafipfonsolredcont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont(struct.getConafiprenateacont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont(struct.getConafipasigfamcont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont(struct.getConafipfonnacempcont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont(struct.getConafipleyrietrabcont());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1(struct.getConafipsubt1());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto(struct.getConafipconcepto());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Libre(struct.getLibre());
      setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo(struct.getConafiptipo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConceptosAfipWizardData_Concepto1 getStruct( )
   {
      web.StructSdtConceptosAfipWizardData_Concepto1 struct = new web.StructSdtConceptosAfipWizardData_Concepto1 ();
      struct.setConafipsipaapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo());
      struct.setConafipinssjypapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo());
      struct.setConafipobrasocapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo());
      struct.setConafipfonsolredapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo());
      struct.setConafiprenateaapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo());
      struct.setConafipregdifapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo());
      struct.setConafipregespapo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo());
      struct.setConafipsipacont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont());
      struct.setConafipinssjypcont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont());
      struct.setConafipobrasoccont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont());
      struct.setConafipfonsolredcont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont());
      struct.setConafiprenateacont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont());
      struct.setConafipasigfamcont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont());
      struct.setConafipfonnacempcont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont());
      struct.setConafipleyrietrabcont(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont());
      struct.setConafipsubt1(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1());
      struct.setConafipconcepto(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto());
      struct.setLibre(getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre());
      struct.setConafiptipo(getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo());
      return struct ;
   }

   protected byte gxTv_SdtConceptosAfipWizardData_Concepto1_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1 ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Libre ;
   protected String gxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

