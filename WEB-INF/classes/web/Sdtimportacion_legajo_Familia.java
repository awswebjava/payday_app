package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_legajo_Familia extends GxSilentTrnSdt
{
   public Sdtimportacion_legajo_Familia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_legajo_Familia.class));
   }

   public Sdtimportacion_legajo_Familia( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_legajo_Familia");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_legajo_Familia( int remoteHandle ,
                                         StructSdtimportacion_legajo_Familia struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public Sdtimportacion_legajo_Familia( )
   {
      super( new ModelContext(Sdtimportacion_legajo_Familia.class), "Sdtimportacion_legajo_Familia");
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
      return (Object[][])(new Object[][]{new Object[]{"MigrLegFamSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Familia");
      metadata.set("BT", "importacion_legajoFamilia");
      metadata.set("PK", "[ \"MigrLegFamSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\",\"MigrLegNumero\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamSec") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamParen") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNroDoc") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDedGan") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamAdh") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDiscap") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNomApe") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamSec_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamParen_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNroDoc_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDedGan_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamAdh_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDiscap_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNomApe_Z") )
            {
               gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
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
         sName = "importacion_legajo.Familia" ;
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
      oWriter.writeElement("MigrLegFamSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamParen", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamNroDoc", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamDedGan", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamAdh", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamDiscap", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamNomApe", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFamFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_legajo_Familia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Familia_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Familia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamParen_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamNroDoc_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamDedGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamAdh_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamDiscap_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamNomApe_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFamFecNac_Z", sDateCnv);
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
      AddObjectProperty("MigrLegFamSec", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamParen", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamNroDoc", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamDedGan", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamAdh", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamDiscap", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamNomApe", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFamFecNac", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_legajo_Familia_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_Sdtimportacion_legajo_Familia_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_legajo_Familia_Initialized, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamSec_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamParen_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamNroDoc_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamDedGan_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamAdh_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamDiscap_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamNomApe_Z", gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFamFecNac_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_legajo_Familia sdt )
   {
      if ( sdt.IsDirty("MigrLegFamSec") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec() ;
      }
      if ( sdt.IsDirty("MigrLegFamParen") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen() ;
      }
      if ( sdt.IsDirty("MigrLegFamNroDoc") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc() ;
      }
      if ( sdt.IsDirty("MigrLegFamDedGan") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan() ;
      }
      if ( sdt.IsDirty("MigrLegFamAdh") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh() ;
      }
      if ( sdt.IsDirty("MigrLegFamDiscap") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap() ;
      }
      if ( sdt.IsDirty("MigrLegFamNomApe") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape() ;
      }
      if ( sdt.IsDirty("MigrLegFamFecNac") )
      {
         gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac = sdt.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac() ;
      }
   }

   public short getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec( short value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamsec");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamparen");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamnrodoc");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamdedgan");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamadh");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamdiscap");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamnomape");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamfecnac");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Mode( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Mode ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Mode( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_legajo_Familia_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Familia_Modified( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Modified ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Modified( short value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_Sdtimportacion_legajo_Familia_Modified = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Modified_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Familia_Initialized( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Initialized ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Initialized( short value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_legajo_Familia_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z( short value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamsec_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z = (short)(0) ;
      SetDirty("Migrlegfamsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamparen_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z = "" ;
      SetDirty("Migrlegfamparen_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamnrodoc_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z = "" ;
      SetDirty("Migrlegfamnrodoc_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamdedgan_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z = DecimalUtil.ZERO ;
      SetDirty("Migrlegfamdedgan_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamadh_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z = "" ;
      SetDirty("Migrlegfamadh_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamdiscap_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z = "" ;
      SetDirty("Migrlegfamdiscap_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamnomape_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z = "" ;
      SetDirty("Migrlegfamnomape_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_Familia_Modified = (short)(1) ;
      SetDirty("Migrlegfamfecnac_Z");
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfamfecnac_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_legajo_Familia_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Familia_Mode = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z = "" ;
      gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_legajo_Familia_N ;
   }

   public web.Sdtimportacion_legajo_Familia Clone( )
   {
      return (web.Sdtimportacion_legajo_Familia)(clone()) ;
   }

   public void setStruct( web.StructSdtimportacion_legajo_Familia struct )
   {
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec(struct.getMigrlegfamsec());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen(struct.getMigrlegfamparen());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc(struct.getMigrlegfamnrodoc());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan(struct.getMigrlegfamdedgan());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh(struct.getMigrlegfamadh());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap(struct.getMigrlegfamdiscap());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape(struct.getMigrlegfamnomape());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac(struct.getMigrlegfamfecnac());
      setgxTv_Sdtimportacion_legajo_Familia_Mode(struct.getMode());
      setgxTv_Sdtimportacion_legajo_Familia_Modified(struct.getModified());
      setgxTv_Sdtimportacion_legajo_Familia_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z(struct.getMigrlegfamsec_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z(struct.getMigrlegfamparen_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z(struct.getMigrlegfamnrodoc_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z(struct.getMigrlegfamdedgan_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z(struct.getMigrlegfamadh_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z(struct.getMigrlegfamdiscap_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z(struct.getMigrlegfamnomape_Z());
      setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z(struct.getMigrlegfamfecnac_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_legajo_Familia getStruct( )
   {
      web.StructSdtimportacion_legajo_Familia struct = new web.StructSdtimportacion_legajo_Familia ();
      struct.setMigrlegfamsec(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec());
      struct.setMigrlegfamparen(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen());
      struct.setMigrlegfamnrodoc(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc());
      struct.setMigrlegfamdedgan(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan());
      struct.setMigrlegfamadh(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh());
      struct.setMigrlegfamdiscap(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap());
      struct.setMigrlegfamnomape(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape());
      struct.setMigrlegfamfecnac(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac());
      struct.setMode(getgxTv_Sdtimportacion_legajo_Familia_Mode());
      struct.setModified(getgxTv_Sdtimportacion_legajo_Familia_Modified());
      struct.setInitialized(getgxTv_Sdtimportacion_legajo_Familia_Initialized());
      struct.setMigrlegfamsec_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z());
      struct.setMigrlegfamparen_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z());
      struct.setMigrlegfamnrodoc_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z());
      struct.setMigrlegfamdedgan_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z());
      struct.setMigrlegfamadh_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z());
      struct.setMigrlegfamdiscap_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z());
      struct.setMigrlegfamnomape_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z());
      struct.setMigrlegfamfecnac_Z(getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_legajo_Familia_N ;
   private short gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec ;
   private short gxTv_Sdtimportacion_legajo_Familia_Modified ;
   private short gxTv_Sdtimportacion_legajo_Familia_Initialized ;
   private short gxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap ;
   private String gxTv_Sdtimportacion_legajo_Familia_Mode ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z ;
   private String gxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z ;
}

