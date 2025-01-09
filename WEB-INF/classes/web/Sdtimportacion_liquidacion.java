package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_liquidacion extends GxSilentTrnSdt
{
   public Sdtimportacion_liquidacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_liquidacion.class));
   }

   public Sdtimportacion_liquidacion( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_liquidacion");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_liquidacion( int remoteHandle ,
                                      StructSdtimportacion_liquidacion struct )
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
                     short AV88ImpLiqSec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Short.valueOf(AV88ImpLiqSec)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"ImpLiqSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_liquidacion");
      metadata.set("BT", "importacion_liquidacion");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtimportacion_liquidacion_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_liquidacion_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFec") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_liquidacion_Impliqfec = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_Sdtimportacion_liquidacion_Impliqfec = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFile") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfile=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileName") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfilename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileType") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileNameAndType") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_liquidacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_liquidacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqFec_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileName_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileType_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConFileNameAndType_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = oReader.getValue() ;
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
         sName = "importacion_liquidacion" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Impliqsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtimportacion_liquidacion_Impliqfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ImpLiqFec", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConFile", GXutil.blobToBase64( gxTv_Sdtimportacion_liquidacion_Impliqconfile));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConFileName", gxTv_Sdtimportacion_liquidacion_Impliqconfilename);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConFileType", gxTv_Sdtimportacion_liquidacion_Impliqconfiletype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConFileNameAndType", gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_liquidacion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_Impliqsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtimportacion_liquidacion_Impliqfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ImpLiqFec_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConFileName_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConFileType_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqConFileNameAndType_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_liquidacion_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_liquidacion_Empcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSec", gxTv_Sdtimportacion_liquidacion_Impliqsec, false, includeNonInitialized);
      datetime_STZ = gxTv_Sdtimportacion_liquidacion_Impliqfec ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ImpLiqFec", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConFile", gxTv_Sdtimportacion_liquidacion_Impliqconfile, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConFileName", gxTv_Sdtimportacion_liquidacion_Impliqconfilename, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConFileType", gxTv_Sdtimportacion_liquidacion_Impliqconfiletype, false, includeNonInitialized);
      AddObjectProperty("ImpLiqConFileNameAndType", gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_liquidacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_liquidacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_liquidacion_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_liquidacion_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSec_Z", gxTv_Sdtimportacion_liquidacion_Impliqsec_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_Sdtimportacion_liquidacion_Impliqfec_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ImpLiqFec_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConFileName_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConFileType_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqConFileNameAndType_Z", gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_liquidacion sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Clicod = sdt.getgxTv_Sdtimportacion_liquidacion_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Empcod = sdt.getgxTv_Sdtimportacion_liquidacion_Empcod() ;
      }
      if ( sdt.IsDirty("ImpLiqSec") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqsec = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqsec() ;
      }
      if ( sdt.IsDirty("ImpLiqFec") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqfec = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqfec() ;
      }
      if ( sdt.IsDirty("ImpLiqConFile") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqconfile = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqconfile() ;
      }
      if ( sdt.IsDirty("ImpLiqConFileName") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqconfilename = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqconfilename() ;
      }
      if ( sdt.IsDirty("ImpLiqConFileType") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype() ;
      }
      if ( sdt.IsDirty("ImpLiqConFileNameAndType") )
      {
         gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = sdt.getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype() ;
      }
   }

   public int getgxTv_Sdtimportacion_liquidacion_Clicod( )
   {
      return gxTv_Sdtimportacion_liquidacion_Clicod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Clicod( int value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_Clicod != value )
      {
         gxTv_Sdtimportacion_liquidacion_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_liquidacion_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_Empcod( )
   {
      return gxTv_Sdtimportacion_liquidacion_Empcod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Empcod( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_Empcod != value )
      {
         gxTv_Sdtimportacion_liquidacion_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_liquidacion_Empcod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_Impliqsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqsec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_Impliqsec != value )
      {
         gxTv_Sdtimportacion_liquidacion_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z_SetNull( );
      }
      SetDirty("Impliqsec");
      gxTv_Sdtimportacion_liquidacion_Impliqsec = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_liquidacion_Impliqfec( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqfec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqfec( java.util.Date value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqfec");
      gxTv_Sdtimportacion_liquidacion_Impliqfec = value ;
   }

   @GxUpload
   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfile( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfile ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfile( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfile");
      gxTv_Sdtimportacion_liquidacion_Impliqconfile = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfile_SetBlob( String blob ,
                                                                         String fileName ,
                                                                         String fileType )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqconfile = blob ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename = fileName ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = fileType ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfilename( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilename ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilename( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfilename");
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfiletype ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfiletype");
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfilenameandtype");
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Mode( )
   {
      return gxTv_Sdtimportacion_liquidacion_Mode ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Mode( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_liquidacion_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_Initialized( )
   {
      return gxTv_Sdtimportacion_liquidacion_Initialized ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Initialized( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_liquidacion_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_liquidacion_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_liquidacion_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_liquidacion_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_Impliqsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqsec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqsec_Z");
      gxTv_Sdtimportacion_liquidacion_Impliqsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqsec_Z = (short)(0) ;
      SetDirty("Impliqsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Impliqsec_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_liquidacion_Impliqfec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqfec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqfec_Z");
      gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Impliqfec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Impliqfec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfilename_Z");
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = "" ;
      SetDirty("Impliqconfilename_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfiletype_Z");
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = "" ;
      SetDirty("Impliqconfiletype_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      SetDirty("Impliqconfilenameandtype_Z");
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = "" ;
      SetDirty("Impliqconfilenameandtype_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_liquidacion_bc obj;
      obj = new web.importacion_liquidacion_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(1) ;
      gxTv_Sdtimportacion_liquidacion_Impliqfec = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtimportacion_liquidacion_Impliqconfile = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = "" ;
      gxTv_Sdtimportacion_liquidacion_Mode = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_liquidacion_N ;
   }

   public web.Sdtimportacion_liquidacion Clone( )
   {
      web.Sdtimportacion_liquidacion sdt;
      web.importacion_liquidacion_bc obj;
      sdt = (web.Sdtimportacion_liquidacion)(clone()) ;
      obj = (web.importacion_liquidacion_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_liquidacion struct )
   {
      setgxTv_Sdtimportacion_liquidacion_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_liquidacion_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_liquidacion_Impliqsec(struct.getImpliqsec());
      setgxTv_Sdtimportacion_liquidacion_Impliqfec(struct.getImpliqfec());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfile(struct.getImpliqconfile());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfilename(struct.getImpliqconfilename());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype(struct.getImpliqconfiletype());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype(struct.getImpliqconfilenameandtype());
      setgxTv_Sdtimportacion_liquidacion_Mode(struct.getMode());
      setgxTv_Sdtimportacion_liquidacion_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_liquidacion_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_liquidacion_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z(struct.getImpliqsec_Z());
      setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z(struct.getImpliqfec_Z());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z(struct.getImpliqconfilename_Z());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z(struct.getImpliqconfiletype_Z());
      setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z(struct.getImpliqconfilenameandtype_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_liquidacion getStruct( )
   {
      web.StructSdtimportacion_liquidacion struct = new web.StructSdtimportacion_liquidacion ();
      struct.setClicod(getgxTv_Sdtimportacion_liquidacion_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_liquidacion_Empcod());
      struct.setImpliqsec(getgxTv_Sdtimportacion_liquidacion_Impliqsec());
      struct.setImpliqfec(getgxTv_Sdtimportacion_liquidacion_Impliqfec());
      struct.setImpliqconfile(getgxTv_Sdtimportacion_liquidacion_Impliqconfile());
      struct.setImpliqconfilename(getgxTv_Sdtimportacion_liquidacion_Impliqconfilename());
      struct.setImpliqconfiletype(getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype());
      struct.setImpliqconfilenameandtype(getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype());
      struct.setMode(getgxTv_Sdtimportacion_liquidacion_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_liquidacion_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_liquidacion_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_liquidacion_Empcod_Z());
      struct.setImpliqsec_Z(getgxTv_Sdtimportacion_liquidacion_Impliqsec_Z());
      struct.setImpliqfec_Z(getgxTv_Sdtimportacion_liquidacion_Impliqfec_Z());
      struct.setImpliqconfilename_Z(getgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z());
      struct.setImpliqconfiletype_Z(getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z());
      struct.setImpliqconfilenameandtype_Z(getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_liquidacion_N ;
   private short gxTv_Sdtimportacion_liquidacion_Empcod ;
   private short gxTv_Sdtimportacion_liquidacion_Impliqsec ;
   private short gxTv_Sdtimportacion_liquidacion_Initialized ;
   private short gxTv_Sdtimportacion_liquidacion_Empcod_Z ;
   private short gxTv_Sdtimportacion_liquidacion_Impliqsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_liquidacion_Clicod ;
   private int gxTv_Sdtimportacion_liquidacion_Clicod_Z ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfiletype ;
   private String gxTv_Sdtimportacion_liquidacion_Mode ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtimportacion_liquidacion_Impliqfec ;
   private java.util.Date gxTv_Sdtimportacion_liquidacion_Impliqfec_Z ;
   private java.util.Date datetime_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfile ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfilename ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z ;
   private String gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z ;
}

