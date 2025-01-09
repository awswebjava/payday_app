package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtF1357_Remuneracion extends GxUserType
{
   public SdtF1357_Remuneracion( )
   {
      this(  new ModelContext(SdtF1357_Remuneracion.class));
   }

   public SdtF1357_Remuneracion( ModelContext context )
   {
      super( context, "SdtF1357_Remuneracion");
   }

   public SdtF1357_Remuneracion( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtF1357_Remuneracion");
   }

   public SdtF1357_Remuneracion( StructSdtF1357_Remuneracion struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BruGra") )
            {
               gxTv_SdtF1357_Remuneracion_Brugra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NoHabGra") )
            {
               gxTv_SdtF1357_Remuneracion_Nohabgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SacCuo1Gra") )
            {
               gxTv_SdtF1357_Remuneracion_Saccuo1gra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SacCuo2Gra") )
            {
               gxTv_SdtF1357_Remuneracion_Saccuo2gra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "HorExtGra") )
            {
               gxTv_SdtF1357_Remuneracion_Horextgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MovViaGra") )
            {
               gxTv_SdtF1357_Remuneracion_Movviagra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DocenGra") )
            {
               gxTv_SdtF1357_Remuneracion_Docengra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExenSinExt") )
            {
               gxTv_SdtF1357_Remuneracion_Exensinext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExenExt") )
            {
               gxTv_SdtF1357_Remuneracion_Exenext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MovViaExen") )
            {
               gxTv_SdtF1357_Remuneracion_Movviaexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DocenExen") )
            {
               gxTv_SdtF1357_Remuneracion_Docenexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NoHabExen") )
            {
               gxTv_SdtF1357_Remuneracion_Nohabexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SacCuo1Exen") )
            {
               gxTv_SdtF1357_Remuneracion_Saccuo1exen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SacCuo2Exen") )
            {
               gxTv_SdtF1357_Remuneracion_Saccuo2exen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AjustesGra") )
            {
               gxTv_SdtF1357_Remuneracion_Ajustesgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AjustesExen") )
            {
               gxTv_SdtF1357_Remuneracion_Ajustesexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ExenLey27549") )
            {
               gxTv_SdtF1357_Remuneracion_Exenley27549 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BonosGra") )
            {
               gxTv_SdtF1357_Remuneracion_Bonosgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FallosGra") )
            {
               gxTv_SdtF1357_Remuneracion_Fallosgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SimilaresGra") )
            {
               gxTv_SdtF1357_Remuneracion_Similaresgra = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BonosExen") )
            {
               gxTv_SdtF1357_Remuneracion_Bonosexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FallosExen") )
            {
               gxTv_SdtF1357_Remuneracion_Fallosexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SimilaresExen") )
            {
               gxTv_SdtF1357_Remuneracion_Similaresexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TeletrabajoExen") )
            {
               gxTv_SdtF1357_Remuneracion_Teletrabajoexen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MilitarExen") )
            {
               gxTv_SdtF1357_Remuneracion_Militarexen = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "F1357_Remuneracion" ;
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
      oWriter.writeElement("BruGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Brugra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("NoHabGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Nohabgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SacCuo1Gra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo1gra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SacCuo2Gra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo2gra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("HorExtGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Horextgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MovViaGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Movviagra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("DocenGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Docengra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ExenSinExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exensinext, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ExenExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exenext, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MovViaExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Movviaexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("DocenExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Docenexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("NoHabExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Nohabexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SacCuo1Exen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo1exen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SacCuo2Exen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo2exen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AjustesGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Ajustesgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AjustesExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Ajustesexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ExenLey27549", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exenley27549, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BonosGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Bonosgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FallosGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Fallosgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SimilaresGra", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Similaresgra, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BonosExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Bonosexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FallosExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Fallosexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SimilaresExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Similaresexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TeletrabajoExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Teletrabajoexen, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MilitarExen", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Militarexen, 16, 2)));
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
      AddObjectProperty("BruGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Brugra, 16, 2)), false, false);
      AddObjectProperty("NoHabGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Nohabgra, 16, 2)), false, false);
      AddObjectProperty("SacCuo1Gra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo1gra, 16, 2)), false, false);
      AddObjectProperty("SacCuo2Gra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo2gra, 16, 2)), false, false);
      AddObjectProperty("HorExtGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Horextgra, 16, 2)), false, false);
      AddObjectProperty("MovViaGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Movviagra, 16, 2)), false, false);
      AddObjectProperty("DocenGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Docengra, 16, 2)), false, false);
      AddObjectProperty("ExenSinExt", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exensinext, 16, 2)), false, false);
      AddObjectProperty("ExenExt", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exenext, 16, 2)), false, false);
      AddObjectProperty("MovViaExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Movviaexen, 16, 2)), false, false);
      AddObjectProperty("DocenExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Docenexen, 16, 2)), false, false);
      AddObjectProperty("NoHabExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Nohabexen, 16, 2)), false, false);
      AddObjectProperty("SacCuo1Exen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo1exen, 16, 2)), false, false);
      AddObjectProperty("SacCuo2Exen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Saccuo2exen, 16, 2)), false, false);
      AddObjectProperty("AjustesGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Ajustesgra, 16, 2)), false, false);
      AddObjectProperty("AjustesExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Ajustesexen, 16, 2)), false, false);
      AddObjectProperty("ExenLey27549", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Exenley27549, 16, 2)), false, false);
      AddObjectProperty("BonosGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Bonosgra, 16, 2)), false, false);
      AddObjectProperty("FallosGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Fallosgra, 16, 2)), false, false);
      AddObjectProperty("SimilaresGra", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Similaresgra, 16, 2)), false, false);
      AddObjectProperty("BonosExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Bonosexen, 16, 2)), false, false);
      AddObjectProperty("FallosExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Fallosexen, 16, 2)), false, false);
      AddObjectProperty("SimilaresExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Similaresexen, 16, 2)), false, false);
      AddObjectProperty("TeletrabajoExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Teletrabajoexen, 16, 2)), false, false);
      AddObjectProperty("MilitarExen", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_Remuneracion_Militarexen, 16, 2)), false, false);
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Brugra( )
   {
      return gxTv_SdtF1357_Remuneracion_Brugra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Brugra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Brugra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Nohabgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Nohabgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Nohabgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Nohabgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Saccuo1gra( )
   {
      return gxTv_SdtF1357_Remuneracion_Saccuo1gra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Saccuo1gra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Saccuo1gra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Saccuo2gra( )
   {
      return gxTv_SdtF1357_Remuneracion_Saccuo2gra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Saccuo2gra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Saccuo2gra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Horextgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Horextgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Horextgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Horextgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Movviagra( )
   {
      return gxTv_SdtF1357_Remuneracion_Movviagra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Movviagra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Movviagra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Docengra( )
   {
      return gxTv_SdtF1357_Remuneracion_Docengra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Docengra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Docengra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Exensinext( )
   {
      return gxTv_SdtF1357_Remuneracion_Exensinext ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Exensinext( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Exensinext = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Exenext( )
   {
      return gxTv_SdtF1357_Remuneracion_Exenext ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Exenext( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Exenext = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Movviaexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Movviaexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Movviaexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Movviaexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Docenexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Docenexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Docenexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Docenexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Nohabexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Nohabexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Nohabexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Nohabexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Saccuo1exen( )
   {
      return gxTv_SdtF1357_Remuneracion_Saccuo1exen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Saccuo1exen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Saccuo1exen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Saccuo2exen( )
   {
      return gxTv_SdtF1357_Remuneracion_Saccuo2exen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Saccuo2exen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Saccuo2exen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Ajustesgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Ajustesgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Ajustesgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Ajustesgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Ajustesexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Ajustesexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Ajustesexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Ajustesexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Exenley27549( )
   {
      return gxTv_SdtF1357_Remuneracion_Exenley27549 ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Exenley27549( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Exenley27549 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Bonosgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Bonosgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Bonosgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Bonosgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Fallosgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Fallosgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Fallosgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Fallosgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Similaresgra( )
   {
      return gxTv_SdtF1357_Remuneracion_Similaresgra ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Similaresgra( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Similaresgra = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Bonosexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Bonosexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Bonosexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Bonosexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Fallosexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Fallosexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Fallosexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Fallosexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Similaresexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Similaresexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Similaresexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Similaresexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Teletrabajoexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Teletrabajoexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Teletrabajoexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Teletrabajoexen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_Remuneracion_Militarexen( )
   {
      return gxTv_SdtF1357_Remuneracion_Militarexen ;
   }

   public void setgxTv_SdtF1357_Remuneracion_Militarexen( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_Remuneracion_N = (byte)(0) ;
      gxTv_SdtF1357_Remuneracion_Militarexen = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtF1357_Remuneracion_Brugra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_N = (byte)(1) ;
      gxTv_SdtF1357_Remuneracion_Nohabgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Saccuo1gra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Saccuo2gra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Horextgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Movviagra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Docengra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Exensinext = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Exenext = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Movviaexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Docenexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Nohabexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Saccuo1exen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Saccuo2exen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Ajustesgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Ajustesexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Exenley27549 = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Bonosgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Fallosgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Similaresgra = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Bonosexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Fallosexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Similaresexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Teletrabajoexen = DecimalUtil.ZERO ;
      gxTv_SdtF1357_Remuneracion_Militarexen = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtF1357_Remuneracion_N ;
   }

   public web.SdtF1357_Remuneracion Clone( )
   {
      return (web.SdtF1357_Remuneracion)(clone()) ;
   }

   public void setStruct( web.StructSdtF1357_Remuneracion struct )
   {
      setgxTv_SdtF1357_Remuneracion_Brugra(struct.getBrugra());
      setgxTv_SdtF1357_Remuneracion_Nohabgra(struct.getNohabgra());
      setgxTv_SdtF1357_Remuneracion_Saccuo1gra(struct.getSaccuo1gra());
      setgxTv_SdtF1357_Remuneracion_Saccuo2gra(struct.getSaccuo2gra());
      setgxTv_SdtF1357_Remuneracion_Horextgra(struct.getHorextgra());
      setgxTv_SdtF1357_Remuneracion_Movviagra(struct.getMovviagra());
      setgxTv_SdtF1357_Remuneracion_Docengra(struct.getDocengra());
      setgxTv_SdtF1357_Remuneracion_Exensinext(struct.getExensinext());
      setgxTv_SdtF1357_Remuneracion_Exenext(struct.getExenext());
      setgxTv_SdtF1357_Remuneracion_Movviaexen(struct.getMovviaexen());
      setgxTv_SdtF1357_Remuneracion_Docenexen(struct.getDocenexen());
      setgxTv_SdtF1357_Remuneracion_Nohabexen(struct.getNohabexen());
      setgxTv_SdtF1357_Remuneracion_Saccuo1exen(struct.getSaccuo1exen());
      setgxTv_SdtF1357_Remuneracion_Saccuo2exen(struct.getSaccuo2exen());
      setgxTv_SdtF1357_Remuneracion_Ajustesgra(struct.getAjustesgra());
      setgxTv_SdtF1357_Remuneracion_Ajustesexen(struct.getAjustesexen());
      setgxTv_SdtF1357_Remuneracion_Exenley27549(struct.getExenley27549());
      setgxTv_SdtF1357_Remuneracion_Bonosgra(struct.getBonosgra());
      setgxTv_SdtF1357_Remuneracion_Fallosgra(struct.getFallosgra());
      setgxTv_SdtF1357_Remuneracion_Similaresgra(struct.getSimilaresgra());
      setgxTv_SdtF1357_Remuneracion_Bonosexen(struct.getBonosexen());
      setgxTv_SdtF1357_Remuneracion_Fallosexen(struct.getFallosexen());
      setgxTv_SdtF1357_Remuneracion_Similaresexen(struct.getSimilaresexen());
      setgxTv_SdtF1357_Remuneracion_Teletrabajoexen(struct.getTeletrabajoexen());
      setgxTv_SdtF1357_Remuneracion_Militarexen(struct.getMilitarexen());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtF1357_Remuneracion getStruct( )
   {
      web.StructSdtF1357_Remuneracion struct = new web.StructSdtF1357_Remuneracion ();
      struct.setBrugra(getgxTv_SdtF1357_Remuneracion_Brugra());
      struct.setNohabgra(getgxTv_SdtF1357_Remuneracion_Nohabgra());
      struct.setSaccuo1gra(getgxTv_SdtF1357_Remuneracion_Saccuo1gra());
      struct.setSaccuo2gra(getgxTv_SdtF1357_Remuneracion_Saccuo2gra());
      struct.setHorextgra(getgxTv_SdtF1357_Remuneracion_Horextgra());
      struct.setMovviagra(getgxTv_SdtF1357_Remuneracion_Movviagra());
      struct.setDocengra(getgxTv_SdtF1357_Remuneracion_Docengra());
      struct.setExensinext(getgxTv_SdtF1357_Remuneracion_Exensinext());
      struct.setExenext(getgxTv_SdtF1357_Remuneracion_Exenext());
      struct.setMovviaexen(getgxTv_SdtF1357_Remuneracion_Movviaexen());
      struct.setDocenexen(getgxTv_SdtF1357_Remuneracion_Docenexen());
      struct.setNohabexen(getgxTv_SdtF1357_Remuneracion_Nohabexen());
      struct.setSaccuo1exen(getgxTv_SdtF1357_Remuneracion_Saccuo1exen());
      struct.setSaccuo2exen(getgxTv_SdtF1357_Remuneracion_Saccuo2exen());
      struct.setAjustesgra(getgxTv_SdtF1357_Remuneracion_Ajustesgra());
      struct.setAjustesexen(getgxTv_SdtF1357_Remuneracion_Ajustesexen());
      struct.setExenley27549(getgxTv_SdtF1357_Remuneracion_Exenley27549());
      struct.setBonosgra(getgxTv_SdtF1357_Remuneracion_Bonosgra());
      struct.setFallosgra(getgxTv_SdtF1357_Remuneracion_Fallosgra());
      struct.setSimilaresgra(getgxTv_SdtF1357_Remuneracion_Similaresgra());
      struct.setBonosexen(getgxTv_SdtF1357_Remuneracion_Bonosexen());
      struct.setFallosexen(getgxTv_SdtF1357_Remuneracion_Fallosexen());
      struct.setSimilaresexen(getgxTv_SdtF1357_Remuneracion_Similaresexen());
      struct.setTeletrabajoexen(getgxTv_SdtF1357_Remuneracion_Teletrabajoexen());
      struct.setMilitarexen(getgxTv_SdtF1357_Remuneracion_Militarexen());
      return struct ;
   }

   protected byte gxTv_SdtF1357_Remuneracion_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Brugra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Nohabgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Saccuo1gra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Saccuo2gra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Horextgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Movviagra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Docengra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Exensinext ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Exenext ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Movviaexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Docenexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Nohabexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Saccuo1exen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Saccuo2exen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Ajustesgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Ajustesexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Exenley27549 ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Bonosgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Fallosgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Similaresgra ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Bonosexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Fallosexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Similaresexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Teletrabajoexen ;
   protected java.math.BigDecimal gxTv_SdtF1357_Remuneracion_Militarexen ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

