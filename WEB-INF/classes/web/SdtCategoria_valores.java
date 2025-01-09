package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCategoria_valores extends GxSilentTrnSdt
{
   public SdtCategoria_valores( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCategoria_valores.class));
   }

   public SdtCategoria_valores( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtCategoria_valores");
      initialize( remoteHandle) ;
   }

   public SdtCategoria_valores( int remoteHandle ,
                                StructSdtCategoria_valores struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtCategoria_valores( )
   {
      super( new ModelContext(SdtCategoria_valores.class), "SdtCategoria_valores");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CatVigencia", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "valores");
      metadata.set("BT", "Categoriavalores1");
      metadata.set("PK", "[ \"CatVigencia\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"CatCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatVigencia") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtCategoria_valores_Catvigencia = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtCategoria_valores_Catvigencia = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatBasico") )
            {
               gxTv_SdtCategoria_valores_Catbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatValorHora") )
            {
               gxTv_SdtCategoria_valores_Catvalorhora = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdicional") )
            {
               gxTv_SdtCategoria_valores_Catadicional = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdiHora") )
            {
               gxTv_SdtCategoria_valores_Catadihora = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscBasico") )
            {
               gxTv_SdtCategoria_valores_Escbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscAdicional") )
            {
               gxTv_SdtCategoria_valores_Escadicional = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCategoria_valores_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtCategoria_valores_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCategoria_valores_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatVigencia_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtCategoria_valores_Catvigencia_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtCategoria_valores_Catvigencia_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatBasico_Z") )
            {
               gxTv_SdtCategoria_valores_Catbasico_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatValorHora_Z") )
            {
               gxTv_SdtCategoria_valores_Catvalorhora_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdicional_Z") )
            {
               gxTv_SdtCategoria_valores_Catadicional_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdiHora_Z") )
            {
               gxTv_SdtCategoria_valores_Catadihora_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscBasico_Z") )
            {
               gxTv_SdtCategoria_valores_Escbasico_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscAdicional_Z") )
            {
               gxTv_SdtCategoria_valores_Escadicional_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatBasico_N") )
            {
               gxTv_SdtCategoria_valores_Catbasico_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatValorHora_N") )
            {
               gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdicional_N") )
            {
               gxTv_SdtCategoria_valores_Catadicional_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAdiHora_N") )
            {
               gxTv_SdtCategoria_valores_Catadihora_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Categoria.valores" ;
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
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("CatVigencia", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatBasico", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatValorHora", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catvalorhora, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatAdicional", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catadicional, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatAdiHora", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catadihora, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscBasico", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Escbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscAdicional", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Escadicional, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCategoria_valores_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CatVigencia_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatBasico_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catbasico_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatValorHora_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catvalorhora_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAdicional_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catadicional_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAdiHora_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Catadihora_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscBasico_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Escbasico_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscAdicional_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtCategoria_valores_Escadicional_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatBasico_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Catbasico_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatValorHora_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Catvalorhora_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAdicional_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Catadicional_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAdiHora_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_valores_Catadihora_N, 1, 0)));
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
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCategoria_valores_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CatVigencia", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("CatBasico", gxTv_SdtCategoria_valores_Catbasico, false, includeNonInitialized);
      AddObjectProperty("CatBasico_N", gxTv_SdtCategoria_valores_Catbasico_N, false, includeNonInitialized);
      AddObjectProperty("CatValorHora", gxTv_SdtCategoria_valores_Catvalorhora, false, includeNonInitialized);
      AddObjectProperty("CatValorHora_N", gxTv_SdtCategoria_valores_Catvalorhora_N, false, includeNonInitialized);
      AddObjectProperty("CatAdicional", gxTv_SdtCategoria_valores_Catadicional, false, includeNonInitialized);
      AddObjectProperty("CatAdicional_N", gxTv_SdtCategoria_valores_Catadicional_N, false, includeNonInitialized);
      AddObjectProperty("CatAdiHora", gxTv_SdtCategoria_valores_Catadihora, false, includeNonInitialized);
      AddObjectProperty("CatAdiHora_N", gxTv_SdtCategoria_valores_Catadihora_N, false, includeNonInitialized);
      AddObjectProperty("EscBasico", gxTv_SdtCategoria_valores_Escbasico, false, includeNonInitialized);
      AddObjectProperty("EscAdicional", gxTv_SdtCategoria_valores_Escadicional, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCategoria_valores_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtCategoria_valores_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCategoria_valores_Initialized, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtCategoria_valores_Catvigencia_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("CatVigencia_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("CatBasico_Z", gxTv_SdtCategoria_valores_Catbasico_Z, false, includeNonInitialized);
         AddObjectProperty("CatValorHora_Z", gxTv_SdtCategoria_valores_Catvalorhora_Z, false, includeNonInitialized);
         AddObjectProperty("CatAdicional_Z", gxTv_SdtCategoria_valores_Catadicional_Z, false, includeNonInitialized);
         AddObjectProperty("CatAdiHora_Z", gxTv_SdtCategoria_valores_Catadihora_Z, false, includeNonInitialized);
         AddObjectProperty("EscBasico_Z", gxTv_SdtCategoria_valores_Escbasico_Z, false, includeNonInitialized);
         AddObjectProperty("EscAdicional_Z", gxTv_SdtCategoria_valores_Escadicional_Z, false, includeNonInitialized);
         AddObjectProperty("CatBasico_N", gxTv_SdtCategoria_valores_Catbasico_N, false, includeNonInitialized);
         AddObjectProperty("CatValorHora_N", gxTv_SdtCategoria_valores_Catvalorhora_N, false, includeNonInitialized);
         AddObjectProperty("CatAdicional_N", gxTv_SdtCategoria_valores_Catadicional_N, false, includeNonInitialized);
         AddObjectProperty("CatAdiHora_N", gxTv_SdtCategoria_valores_Catadihora_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtCategoria_valores sdt )
   {
      if ( sdt.IsDirty("CatVigencia") )
      {
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Catvigencia = sdt.getgxTv_SdtCategoria_valores_Catvigencia() ;
      }
      if ( sdt.IsDirty("CatBasico") )
      {
         gxTv_SdtCategoria_valores_Catbasico_N = sdt.getgxTv_SdtCategoria_valores_Catbasico_N() ;
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Catbasico = sdt.getgxTv_SdtCategoria_valores_Catbasico() ;
      }
      if ( sdt.IsDirty("CatValorHora") )
      {
         gxTv_SdtCategoria_valores_Catvalorhora_N = sdt.getgxTv_SdtCategoria_valores_Catvalorhora_N() ;
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Catvalorhora = sdt.getgxTv_SdtCategoria_valores_Catvalorhora() ;
      }
      if ( sdt.IsDirty("CatAdicional") )
      {
         gxTv_SdtCategoria_valores_Catadicional_N = sdt.getgxTv_SdtCategoria_valores_Catadicional_N() ;
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Catadicional = sdt.getgxTv_SdtCategoria_valores_Catadicional() ;
      }
      if ( sdt.IsDirty("CatAdiHora") )
      {
         gxTv_SdtCategoria_valores_Catadihora_N = sdt.getgxTv_SdtCategoria_valores_Catadihora_N() ;
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Catadihora = sdt.getgxTv_SdtCategoria_valores_Catadihora() ;
      }
      if ( sdt.IsDirty("EscBasico") )
      {
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Escbasico = sdt.getgxTv_SdtCategoria_valores_Escbasico() ;
      }
      if ( sdt.IsDirty("EscAdicional") )
      {
         gxTv_SdtCategoria_valores_N = (byte)(0) ;
         gxTv_SdtCategoria_valores_Escadicional = sdt.getgxTv_SdtCategoria_valores_Escadicional() ;
      }
   }

   public java.util.Date getgxTv_SdtCategoria_valores_Catvigencia( )
   {
      return gxTv_SdtCategoria_valores_Catvigencia ;
   }

   public void setgxTv_SdtCategoria_valores_Catvigencia( java.util.Date value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catvigencia");
      gxTv_SdtCategoria_valores_Catvigencia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catbasico( )
   {
      return gxTv_SdtCategoria_valores_Catbasico ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catbasico_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catbasico");
      gxTv_SdtCategoria_valores_Catbasico = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catbasico_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catbasico = DecimalUtil.ZERO ;
      SetDirty("Catbasico");
   }

   public boolean getgxTv_SdtCategoria_valores_Catbasico_IsNull( )
   {
      return (gxTv_SdtCategoria_valores_Catbasico_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catvalorhora( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catvalorhora");
      gxTv_SdtCategoria_valores_Catvalorhora = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catvalorhora = DecimalUtil.ZERO ;
      SetDirty("Catvalorhora");
   }

   public boolean getgxTv_SdtCategoria_valores_Catvalorhora_IsNull( )
   {
      return (gxTv_SdtCategoria_valores_Catvalorhora_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catadicional( )
   {
      return gxTv_SdtCategoria_valores_Catadicional ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catadicional_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadicional");
      gxTv_SdtCategoria_valores_Catadicional = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadicional_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catadicional = DecimalUtil.ZERO ;
      SetDirty("Catadicional");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadicional_IsNull( )
   {
      return (gxTv_SdtCategoria_valores_Catadicional_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catadihora( )
   {
      return gxTv_SdtCategoria_valores_Catadihora ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catadihora_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadihora");
      gxTv_SdtCategoria_valores_Catadihora = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadihora_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catadihora = DecimalUtil.ZERO ;
      SetDirty("Catadihora");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadihora_IsNull( )
   {
      return (gxTv_SdtCategoria_valores_Catadihora_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Escbasico( )
   {
      return gxTv_SdtCategoria_valores_Escbasico ;
   }

   public void setgxTv_SdtCategoria_valores_Escbasico( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Escbasico");
      gxTv_SdtCategoria_valores_Escbasico = value ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Escadicional( )
   {
      return gxTv_SdtCategoria_valores_Escadicional ;
   }

   public void setgxTv_SdtCategoria_valores_Escadicional( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Escadicional");
      gxTv_SdtCategoria_valores_Escadicional = value ;
   }

   public String getgxTv_SdtCategoria_valores_Mode( )
   {
      return gxTv_SdtCategoria_valores_Mode ;
   }

   public void setgxTv_SdtCategoria_valores_Mode( String value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCategoria_valores_Mode = value ;
   }

   public void setgxTv_SdtCategoria_valores_Mode_SetNull( )
   {
      gxTv_SdtCategoria_valores_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCategoria_valores_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_valores_Modified( )
   {
      return gxTv_SdtCategoria_valores_Modified ;
   }

   public void setgxTv_SdtCategoria_valores_Modified( short value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtCategoria_valores_Modified = value ;
   }

   public void setgxTv_SdtCategoria_valores_Modified_SetNull( )
   {
      gxTv_SdtCategoria_valores_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtCategoria_valores_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_valores_Initialized( )
   {
      return gxTv_SdtCategoria_valores_Initialized ;
   }

   public void setgxTv_SdtCategoria_valores_Initialized( short value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtCategoria_valores_Initialized = value ;
   }

   public void setgxTv_SdtCategoria_valores_Initialized_SetNull( )
   {
      gxTv_SdtCategoria_valores_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCategoria_valores_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtCategoria_valores_Catvigencia_Z( )
   {
      return gxTv_SdtCategoria_valores_Catvigencia_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Catvigencia_Z( java.util.Date value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catvigencia_Z");
      gxTv_SdtCategoria_valores_Catvigencia_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catvigencia_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catvigencia_Z = GXutil.nullDate() ;
      SetDirty("Catvigencia_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Catvigencia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catbasico_Z( )
   {
      return gxTv_SdtCategoria_valores_Catbasico_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catbasico_Z");
      gxTv_SdtCategoria_valores_Catbasico_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catbasico_Z = DecimalUtil.ZERO ;
      SetDirty("Catbasico_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Catbasico_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catvalorhora_Z( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catvalorhora_Z");
      gxTv_SdtCategoria_valores_Catvalorhora_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catvalorhora_Z = DecimalUtil.ZERO ;
      SetDirty("Catvalorhora_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Catvalorhora_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catadicional_Z( )
   {
      return gxTv_SdtCategoria_valores_Catadicional_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadicional_Z");
      gxTv_SdtCategoria_valores_Catadicional_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadicional_Z = DecimalUtil.ZERO ;
      SetDirty("Catadicional_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadicional_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Catadihora_Z( )
   {
      return gxTv_SdtCategoria_valores_Catadihora_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadihora_Z");
      gxTv_SdtCategoria_valores_Catadihora_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadihora_Z = DecimalUtil.ZERO ;
      SetDirty("Catadihora_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadihora_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Escbasico_Z( )
   {
      return gxTv_SdtCategoria_valores_Escbasico_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Escbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Escbasico_Z");
      gxTv_SdtCategoria_valores_Escbasico_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Escbasico_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Escbasico_Z = DecimalUtil.ZERO ;
      SetDirty("Escbasico_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Escbasico_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtCategoria_valores_Escadicional_Z( )
   {
      return gxTv_SdtCategoria_valores_Escadicional_Z ;
   }

   public void setgxTv_SdtCategoria_valores_Escadicional_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Escadicional_Z");
      gxTv_SdtCategoria_valores_Escadicional_Z = value ;
   }

   public void setgxTv_SdtCategoria_valores_Escadicional_Z_SetNull( )
   {
      gxTv_SdtCategoria_valores_Escadicional_Z = DecimalUtil.ZERO ;
      SetDirty("Escadicional_Z");
   }

   public boolean getgxTv_SdtCategoria_valores_Escadicional_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_valores_Catbasico_N( )
   {
      return gxTv_SdtCategoria_valores_Catbasico_N ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catbasico_N");
      gxTv_SdtCategoria_valores_Catbasico_N = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catbasico_N_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catbasico_N = (byte)(0) ;
      SetDirty("Catbasico_N");
   }

   public boolean getgxTv_SdtCategoria_valores_Catbasico_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_valores_Catvalorhora_N( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora_N ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catvalorhora_N");
      gxTv_SdtCategoria_valores_Catvalorhora_N = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catvalorhora_N_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(0) ;
      SetDirty("Catvalorhora_N");
   }

   public boolean getgxTv_SdtCategoria_valores_Catvalorhora_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_valores_Catadicional_N( )
   {
      return gxTv_SdtCategoria_valores_Catadicional_N ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadicional_N");
      gxTv_SdtCategoria_valores_Catadicional_N = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadicional_N_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadicional_N = (byte)(0) ;
      SetDirty("Catadicional_N");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadicional_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_valores_Catadihora_N( )
   {
      return gxTv_SdtCategoria_valores_Catadihora_N ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = (short)(1) ;
      SetDirty("Catadihora_N");
      gxTv_SdtCategoria_valores_Catadihora_N = value ;
   }

   public void setgxTv_SdtCategoria_valores_Catadihora_N_SetNull( )
   {
      gxTv_SdtCategoria_valores_Catadihora_N = (byte)(0) ;
      SetDirty("Catadihora_N");
   }

   public boolean getgxTv_SdtCategoria_valores_Catadihora_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCategoria_valores_Catvigencia = GXutil.nullDate() ;
      gxTv_SdtCategoria_valores_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catbasico = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catvalorhora = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catadicional = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catadihora = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Escbasico = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Escadicional = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Mode = "" ;
      gxTv_SdtCategoria_valores_Catvigencia_Z = GXutil.nullDate() ;
      gxTv_SdtCategoria_valores_Catbasico_Z = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catvalorhora_Z = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catadicional_Z = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Catadihora_Z = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Escbasico_Z = DecimalUtil.ZERO ;
      gxTv_SdtCategoria_valores_Escadicional_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCategoria_valores_N ;
   }

   public web.SdtCategoria_valores Clone( )
   {
      return (web.SdtCategoria_valores)(clone()) ;
   }

   public void setStruct( web.StructSdtCategoria_valores struct )
   {
      setgxTv_SdtCategoria_valores_Catvigencia(struct.getCatvigencia());
      setgxTv_SdtCategoria_valores_Catbasico(struct.getCatbasico());
      setgxTv_SdtCategoria_valores_Catvalorhora(struct.getCatvalorhora());
      setgxTv_SdtCategoria_valores_Catadicional(struct.getCatadicional());
      setgxTv_SdtCategoria_valores_Catadihora(struct.getCatadihora());
      setgxTv_SdtCategoria_valores_Escbasico(struct.getEscbasico());
      setgxTv_SdtCategoria_valores_Escadicional(struct.getEscadicional());
      setgxTv_SdtCategoria_valores_Mode(struct.getMode());
      setgxTv_SdtCategoria_valores_Modified(struct.getModified());
      setgxTv_SdtCategoria_valores_Initialized(struct.getInitialized());
      setgxTv_SdtCategoria_valores_Catvigencia_Z(struct.getCatvigencia_Z());
      setgxTv_SdtCategoria_valores_Catbasico_Z(struct.getCatbasico_Z());
      setgxTv_SdtCategoria_valores_Catvalorhora_Z(struct.getCatvalorhora_Z());
      setgxTv_SdtCategoria_valores_Catadicional_Z(struct.getCatadicional_Z());
      setgxTv_SdtCategoria_valores_Catadihora_Z(struct.getCatadihora_Z());
      setgxTv_SdtCategoria_valores_Escbasico_Z(struct.getEscbasico_Z());
      setgxTv_SdtCategoria_valores_Escadicional_Z(struct.getEscadicional_Z());
      setgxTv_SdtCategoria_valores_Catbasico_N(struct.getCatbasico_N());
      setgxTv_SdtCategoria_valores_Catvalorhora_N(struct.getCatvalorhora_N());
      setgxTv_SdtCategoria_valores_Catadicional_N(struct.getCatadicional_N());
      setgxTv_SdtCategoria_valores_Catadihora_N(struct.getCatadihora_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtCategoria_valores getStruct( )
   {
      web.StructSdtCategoria_valores struct = new web.StructSdtCategoria_valores ();
      struct.setCatvigencia(getgxTv_SdtCategoria_valores_Catvigencia());
      struct.setCatbasico(getgxTv_SdtCategoria_valores_Catbasico());
      struct.setCatvalorhora(getgxTv_SdtCategoria_valores_Catvalorhora());
      struct.setCatadicional(getgxTv_SdtCategoria_valores_Catadicional());
      struct.setCatadihora(getgxTv_SdtCategoria_valores_Catadihora());
      struct.setEscbasico(getgxTv_SdtCategoria_valores_Escbasico());
      struct.setEscadicional(getgxTv_SdtCategoria_valores_Escadicional());
      struct.setMode(getgxTv_SdtCategoria_valores_Mode());
      struct.setModified(getgxTv_SdtCategoria_valores_Modified());
      struct.setInitialized(getgxTv_SdtCategoria_valores_Initialized());
      struct.setCatvigencia_Z(getgxTv_SdtCategoria_valores_Catvigencia_Z());
      struct.setCatbasico_Z(getgxTv_SdtCategoria_valores_Catbasico_Z());
      struct.setCatvalorhora_Z(getgxTv_SdtCategoria_valores_Catvalorhora_Z());
      struct.setCatadicional_Z(getgxTv_SdtCategoria_valores_Catadicional_Z());
      struct.setCatadihora_Z(getgxTv_SdtCategoria_valores_Catadihora_Z());
      struct.setEscbasico_Z(getgxTv_SdtCategoria_valores_Escbasico_Z());
      struct.setEscadicional_Z(getgxTv_SdtCategoria_valores_Escadicional_Z());
      struct.setCatbasico_N(getgxTv_SdtCategoria_valores_Catbasico_N());
      struct.setCatvalorhora_N(getgxTv_SdtCategoria_valores_Catvalorhora_N());
      struct.setCatadicional_N(getgxTv_SdtCategoria_valores_Catadicional_N());
      struct.setCatadihora_N(getgxTv_SdtCategoria_valores_Catadihora_N());
      return struct ;
   }

   private byte gxTv_SdtCategoria_valores_N ;
   private byte gxTv_SdtCategoria_valores_Catbasico_N ;
   private byte gxTv_SdtCategoria_valores_Catvalorhora_N ;
   private byte gxTv_SdtCategoria_valores_Catadicional_N ;
   private byte gxTv_SdtCategoria_valores_Catadihora_N ;
   private short gxTv_SdtCategoria_valores_Modified ;
   private short gxTv_SdtCategoria_valores_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catbasico ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catvalorhora ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catadicional ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catadihora ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Escbasico ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Escadicional ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catbasico_Z ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catvalorhora_Z ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catadicional_Z ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Catadihora_Z ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Escbasico_Z ;
   private java.math.BigDecimal gxTv_SdtCategoria_valores_Escadicional_Z ;
   private String gxTv_SdtCategoria_valores_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtCategoria_valores_Catvigencia ;
   private java.util.Date gxTv_SdtCategoria_valores_Catvigencia_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

