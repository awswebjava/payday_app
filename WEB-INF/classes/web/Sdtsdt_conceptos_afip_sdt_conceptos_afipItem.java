package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_conceptos_afip_sdt_conceptos_afipItem extends GxUserType
{
   public Sdtsdt_conceptos_afip_sdt_conceptos_afipItem( )
   {
      this(  new ModelContext(Sdtsdt_conceptos_afip_sdt_conceptos_afipItem.class));
   }

   public Sdtsdt_conceptos_afip_sdt_conceptos_afipItem( ModelContext context )
   {
      super( context, "Sdtsdt_conceptos_afip_sdt_conceptos_afipItem");
   }

   public Sdtsdt_conceptos_afip_sdt_conceptos_afipItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_conceptos_afip_sdt_conceptos_afipItem");
   }

   public Sdtsdt_conceptos_afip_sdt_conceptos_afipItem( StructSdtsdt_conceptos_afip_sdt_conceptos_afipItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodPropio") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPConcepto") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPMarcaRep") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPAApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPSIPACont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPINSSJyPCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPObraSocCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonSolRedCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRenateaCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPAsigFamCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPFonNacEmpCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPLeyRieTrabCont") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegDifApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPRegEspApo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipEstado") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipo") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipDesc") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAFIPTipoDef") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT1Def") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAfipSubT2Def") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrden") )
            {
               gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_conceptos_afip.sdt_conceptos_afipItem" ;
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
      oWriter.writeElement("ConCodPropio", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPConcepto", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPMarcaRep", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPSIPAApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPSIPACont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPINSSJyPCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPObraSocCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonSolRedCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRenateaCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPAsigFamCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPFonNacEmpCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPLeyRieTrabCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegDifApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPRegEspApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipEstado", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPTipo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT1", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT2", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipDesc", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAFIPTipoDef", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT1Def", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAfipSubT2Def", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrden", GXutil.trim( GXutil.str( gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("ConCodPropio", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio, false, false);
      AddObjectProperty("ConAFIPConcepto", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto, false, false);
      AddObjectProperty("ConAFIPMarcaRep", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep, false, false);
      AddObjectProperty("ConAFIPSIPAApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo, false, false);
      AddObjectProperty("ConAFIPSIPACont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont, false, false);
      AddObjectProperty("ConAFIPINSSJyPApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo, false, false);
      AddObjectProperty("ConAFIPINSSJyPCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont, false, false);
      AddObjectProperty("ConAFIPObraSocApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo, false, false);
      AddObjectProperty("ConAFIPObraSocCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont, false, false);
      AddObjectProperty("ConAFIPFonSolRedApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo, false, false);
      AddObjectProperty("ConAFIPFonSolRedCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont, false, false);
      AddObjectProperty("ConAFIPRenateaApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo, false, false);
      AddObjectProperty("ConAFIPRenateaCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont, false, false);
      AddObjectProperty("ConAFIPAsigFamCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont, false, false);
      AddObjectProperty("ConAFIPFonNacEmpCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont, false, false);
      AddObjectProperty("ConAFIPLeyRieTrabCont", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont, false, false);
      AddObjectProperty("ConAFIPRegDifApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo, false, false);
      AddObjectProperty("ConAFIPRegEspApo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo, false, false);
      AddObjectProperty("ConAfipEstado", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado, false, false);
      AddObjectProperty("ConAFIPTipo", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo, false, false);
      AddObjectProperty("ConAfipSubT1", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1, false, false);
      AddObjectProperty("ConAfipSubT2", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2, false, false);
      AddObjectProperty("ConAfipDesc", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc, false, false);
      AddObjectProperty("ConAFIPTipoDef", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef, false, false);
      AddObjectProperty("ConAfipSubT1Def", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def, false, false);
      AddObjectProperty("ConAfipSubT2Def", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def, false, false);
      AddObjectProperty("ConOrden", gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden, false, false);
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1 ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1 = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2 ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2 = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def = value ;
   }

   public String getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def( String value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def = value ;
   }

   public int getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden ;
   }

   public void setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden( int value )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N = (byte)(1) ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1 = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2 = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def = "" ;
      gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N ;
   }

   public web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem Clone( )
   {
      return (web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_conceptos_afip_sdt_conceptos_afipItem struct )
   {
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio(struct.getConcodpropio());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto(struct.getConafipconcepto());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep(struct.getConafipmarcarep());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo(struct.getConafipsipaapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont(struct.getConafipsipacont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo(struct.getConafipinssjypapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont(struct.getConafipinssjypcont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo(struct.getConafipobrasocapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont(struct.getConafipobrasoccont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo(struct.getConafipfonsolredapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont(struct.getConafipfonsolredcont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo(struct.getConafiprenateaapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont(struct.getConafiprenateacont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont(struct.getConafipasigfamcont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont(struct.getConafipfonnacempcont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont(struct.getConafipleyrietrabcont());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo(struct.getConafipregdifapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo(struct.getConafipregespapo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado(struct.getConafipestado());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo(struct.getConafiptipo());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1(struct.getConafipsubt1());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2(struct.getConafipsubt2());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc(struct.getConafipdesc());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef(struct.getConafiptipodef());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def(struct.getConafipsubt1def());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def(struct.getConafipsubt2def());
      setgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden(struct.getConorden());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_conceptos_afip_sdt_conceptos_afipItem getStruct( )
   {
      web.StructSdtsdt_conceptos_afip_sdt_conceptos_afipItem struct = new web.StructSdtsdt_conceptos_afip_sdt_conceptos_afipItem ();
      struct.setConcodpropio(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio());
      struct.setConafipconcepto(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto());
      struct.setConafipmarcarep(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep());
      struct.setConafipsipaapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo());
      struct.setConafipsipacont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont());
      struct.setConafipinssjypapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo());
      struct.setConafipinssjypcont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont());
      struct.setConafipobrasocapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo());
      struct.setConafipobrasoccont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont());
      struct.setConafipfonsolredapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo());
      struct.setConafipfonsolredcont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont());
      struct.setConafiprenateaapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo());
      struct.setConafiprenateacont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont());
      struct.setConafipasigfamcont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont());
      struct.setConafipfonnacempcont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont());
      struct.setConafipleyrietrabcont(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont());
      struct.setConafipregdifapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo());
      struct.setConafipregespapo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo());
      struct.setConafipestado(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado());
      struct.setConafiptipo(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo());
      struct.setConafipsubt1(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1());
      struct.setConafipsubt2(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2());
      struct.setConafipdesc(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc());
      struct.setConafiptipodef(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef());
      struct.setConafipsubt1def(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def());
      struct.setConafipsubt2def(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def());
      struct.setConorden(getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conorden ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipconcepto ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipmarcarep ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipaapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsipacont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipinssjypcont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasocapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipobrasoccont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonsolredcont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateaapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiprenateacont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipasigfamcont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipfonnacempcont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipleyrietrabcont ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregdifapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipregespapo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipestado ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipo ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1 ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2 ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafiptipodef ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt1def ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipsubt2def ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc ;
}

