package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtvariable_valores extends GxSilentTrnSdt
{
   public Sdtvariable_valores( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtvariable_valores.class));
   }

   public Sdtvariable_valores( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "Sdtvariable_valores");
      initialize( remoteHandle) ;
   }

   public Sdtvariable_valores( int remoteHandle ,
                               StructSdtvariable_valores struct )
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
                     String AV82OpeCliId ,
                     java.util.Date AV754OpeCliVig )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV82OpeCliId,AV754OpeCliVig});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"OpeCliId", String.class}, new Object[]{"OpeCliVig", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "variable_valores");
      metadata.set("BT", "variable_valores");
      metadata.set("PK", "[ \"CliCod\",\"OpeCliId\",\"OpeCliVig\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"OpeCliId\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtvariable_valores_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliId") )
            {
               gxTv_Sdtvariable_valores_Opecliid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtvariable_valores_Opeclivig = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtvariable_valores_Opeclivig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliValor") )
            {
               gxTv_Sdtvariable_valores_Opeclivalor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVPropagar") )
            {
               gxTv_Sdtvariable_valores_Opeclivpropagar = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRetro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtvariable_valores_Opeclivretro = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtvariable_valores_Opeclivretro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliRelSec") )
            {
               gxTv_Sdtvariable_valores_Opeclirelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliRelSecCli") )
            {
               gxTv_Sdtvariable_valores_Opeclirelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRelRef") )
            {
               gxTv_Sdtvariable_valores_Opeclivrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVOld") )
            {
               gxTv_Sdtvariable_valores_Opeclivold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtvariable_valores_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtvariable_valores_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtvariable_valores_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliId_Z") )
            {
               gxTv_Sdtvariable_valores_Opecliid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVig_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtvariable_valores_Opeclivig_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtvariable_valores_Opeclivig_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVPropagar_Z") )
            {
               gxTv_Sdtvariable_valores_Opeclivpropagar_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRetro_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtvariable_valores_Opeclivretro_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtvariable_valores_Opeclivretro_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliRelSec_Z") )
            {
               gxTv_Sdtvariable_valores_Opeclirelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliRelSecCli_Z") )
            {
               gxTv_Sdtvariable_valores_Opeclirelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRelRef_Z") )
            {
               gxTv_Sdtvariable_valores_Opeclivrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVPropagar_N") )
            {
               gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRetro_N") )
            {
               gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "variable_valores" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliId", gxTv_Sdtvariable_valores_Opecliid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("OpeCliVig", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliValor", gxTv_Sdtvariable_valores_Opeclivalor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliVPropagar", GXutil.booltostr( gxTv_Sdtvariable_valores_Opeclivpropagar));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("OpeCliVRetro", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliRelSec", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclirelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliRelSecCli", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclirelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliVRelRef", gxTv_Sdtvariable_valores_Opeclivrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliVOld", gxTv_Sdtvariable_valores_Opeclivold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtvariable_valores_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliId_Z", gxTv_Sdtvariable_valores_Opecliid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("OpeCliVig_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliVPropagar_Z", GXutil.booltostr( gxTv_Sdtvariable_valores_Opeclivpropagar_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("OpeCliVRetro_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliRelSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclirelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclirelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliVRelRef_Z", gxTv_Sdtvariable_valores_Opeclivrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliVPropagar_N", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclivpropagar_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OpeCliVRetro_N", GXutil.trim( GXutil.str( gxTv_Sdtvariable_valores_Opeclivretro_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_Sdtvariable_valores_Clicod, false, includeNonInitialized);
      AddObjectProperty("OpeCliId", gxTv_Sdtvariable_valores_Opecliid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("OpeCliVig", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("OpeCliValor", gxTv_Sdtvariable_valores_Opeclivalor, false, includeNonInitialized);
      AddObjectProperty("OpeCliVPropagar", gxTv_Sdtvariable_valores_Opeclivpropagar, false, includeNonInitialized);
      AddObjectProperty("OpeCliVPropagar_N", gxTv_Sdtvariable_valores_Opeclivpropagar_N, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("OpeCliVRetro", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("OpeCliVRetro_N", gxTv_Sdtvariable_valores_Opeclivretro_N, false, includeNonInitialized);
      AddObjectProperty("OpeCliRelSec", gxTv_Sdtvariable_valores_Opeclirelsec, false, includeNonInitialized);
      AddObjectProperty("OpeCliRelSecCli", gxTv_Sdtvariable_valores_Opeclirelseccli, false, includeNonInitialized);
      AddObjectProperty("OpeCliVRelRef", gxTv_Sdtvariable_valores_Opeclivrelref, false, includeNonInitialized);
      AddObjectProperty("OpeCliVOld", gxTv_Sdtvariable_valores_Opeclivold, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtvariable_valores_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtvariable_valores_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtvariable_valores_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("OpeCliId_Z", gxTv_Sdtvariable_valores_Opecliid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("OpeCliVig_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("OpeCliVPropagar_Z", gxTv_Sdtvariable_valores_Opeclivpropagar_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtvariable_valores_Opeclivretro_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("OpeCliVRetro_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("OpeCliRelSec_Z", gxTv_Sdtvariable_valores_Opeclirelsec_Z, false, includeNonInitialized);
         AddObjectProperty("OpeCliRelSecCli_Z", gxTv_Sdtvariable_valores_Opeclirelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("OpeCliVRelRef_Z", gxTv_Sdtvariable_valores_Opeclivrelref_Z, false, includeNonInitialized);
         AddObjectProperty("OpeCliVPropagar_N", gxTv_Sdtvariable_valores_Opeclivpropagar_N, false, includeNonInitialized);
         AddObjectProperty("OpeCliVRetro_N", gxTv_Sdtvariable_valores_Opeclivretro_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtvariable_valores sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Clicod = sdt.getgxTv_Sdtvariable_valores_Clicod() ;
      }
      if ( sdt.IsDirty("OpeCliId") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opecliid = sdt.getgxTv_Sdtvariable_valores_Opecliid() ;
      }
      if ( sdt.IsDirty("OpeCliVig") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivig = sdt.getgxTv_Sdtvariable_valores_Opeclivig() ;
      }
      if ( sdt.IsDirty("OpeCliValor") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivalor = sdt.getgxTv_Sdtvariable_valores_Opeclivalor() ;
      }
      if ( sdt.IsDirty("OpeCliVPropagar") )
      {
         gxTv_Sdtvariable_valores_Opeclivpropagar_N = sdt.getgxTv_Sdtvariable_valores_Opeclivpropagar_N() ;
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivpropagar = sdt.getgxTv_Sdtvariable_valores_Opeclivpropagar() ;
      }
      if ( sdt.IsDirty("OpeCliVRetro") )
      {
         gxTv_Sdtvariable_valores_Opeclivretro_N = sdt.getgxTv_Sdtvariable_valores_Opeclivretro_N() ;
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivretro = sdt.getgxTv_Sdtvariable_valores_Opeclivretro() ;
      }
      if ( sdt.IsDirty("OpeCliRelSec") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclirelsec = sdt.getgxTv_Sdtvariable_valores_Opeclirelsec() ;
      }
      if ( sdt.IsDirty("OpeCliRelSecCli") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclirelseccli = sdt.getgxTv_Sdtvariable_valores_Opeclirelseccli() ;
      }
      if ( sdt.IsDirty("OpeCliVRelRef") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivrelref = sdt.getgxTv_Sdtvariable_valores_Opeclivrelref() ;
      }
      if ( sdt.IsDirty("OpeCliVOld") )
      {
         gxTv_Sdtvariable_valores_N = (byte)(0) ;
         gxTv_Sdtvariable_valores_Opeclivold = sdt.getgxTv_Sdtvariable_valores_Opeclivold() ;
      }
   }

   public int getgxTv_Sdtvariable_valores_Clicod( )
   {
      return gxTv_Sdtvariable_valores_Clicod ;
   }

   public void setgxTv_Sdtvariable_valores_Clicod( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      if ( gxTv_Sdtvariable_valores_Clicod != value )
      {
         gxTv_Sdtvariable_valores_Mode = "INS" ;
         this.setgxTv_Sdtvariable_valores_Clicod_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opecliid_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivig_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivpropagar_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivretro_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelsec_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelseccli_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivrelref_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtvariable_valores_Clicod = value ;
   }

   public String getgxTv_Sdtvariable_valores_Opecliid( )
   {
      return gxTv_Sdtvariable_valores_Opecliid ;
   }

   public void setgxTv_Sdtvariable_valores_Opecliid( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_Sdtvariable_valores_Opecliid, value) != 0 )
      {
         gxTv_Sdtvariable_valores_Mode = "INS" ;
         this.setgxTv_Sdtvariable_valores_Clicod_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opecliid_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivig_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivpropagar_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivretro_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelsec_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelseccli_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivrelref_Z_SetNull( );
      }
      SetDirty("Opecliid");
      gxTv_Sdtvariable_valores_Opecliid = value ;
   }

   public java.util.Date getgxTv_Sdtvariable_valores_Opeclivig( )
   {
      return gxTv_Sdtvariable_valores_Opeclivig ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivig( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(gxTv_Sdtvariable_valores_Opeclivig), GXutil.resetTime(value)) ) )
      {
         gxTv_Sdtvariable_valores_Mode = "INS" ;
         this.setgxTv_Sdtvariable_valores_Clicod_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opecliid_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivig_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivpropagar_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivretro_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelsec_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclirelseccli_Z_SetNull( );
         this.setgxTv_Sdtvariable_valores_Opeclivrelref_Z_SetNull( );
      }
      SetDirty("Opeclivig");
      gxTv_Sdtvariable_valores_Opeclivig = value ;
   }

   public String getgxTv_Sdtvariable_valores_Opeclivalor( )
   {
      return gxTv_Sdtvariable_valores_Opeclivalor ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivalor( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivalor");
      gxTv_Sdtvariable_valores_Opeclivalor = value ;
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivpropagar( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar( boolean value )
   {
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivpropagar");
      gxTv_Sdtvariable_valores_Opeclivpropagar = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(1) ;
      gxTv_Sdtvariable_valores_Opeclivpropagar = false ;
      SetDirty("Opeclivpropagar");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivpropagar_IsNull( )
   {
      return (gxTv_Sdtvariable_valores_Opeclivpropagar_N==1) ;
   }

   public java.util.Date getgxTv_Sdtvariable_valores_Opeclivretro( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivretro");
      gxTv_Sdtvariable_valores_Opeclivretro = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(1) ;
      gxTv_Sdtvariable_valores_Opeclivretro = GXutil.nullDate() ;
      SetDirty("Opeclivretro");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivretro_IsNull( )
   {
      return (gxTv_Sdtvariable_valores_Opeclivretro_N==1) ;
   }

   public int getgxTv_Sdtvariable_valores_Opeclirelsec( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelsec ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelsec( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclirelsec");
      gxTv_Sdtvariable_valores_Opeclirelsec = value ;
   }

   public int getgxTv_Sdtvariable_valores_Opeclirelseccli( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelseccli ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelseccli( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclirelseccli");
      gxTv_Sdtvariable_valores_Opeclirelseccli = value ;
   }

   public String getgxTv_Sdtvariable_valores_Opeclivrelref( )
   {
      return gxTv_Sdtvariable_valores_Opeclivrelref ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivrelref( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivrelref");
      gxTv_Sdtvariable_valores_Opeclivrelref = value ;
   }

   public String getgxTv_Sdtvariable_valores_Opeclivold( )
   {
      return gxTv_Sdtvariable_valores_Opeclivold ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivold( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivold");
      gxTv_Sdtvariable_valores_Opeclivold = value ;
   }

   public String getgxTv_Sdtvariable_valores_Mode( )
   {
      return gxTv_Sdtvariable_valores_Mode ;
   }

   public void setgxTv_Sdtvariable_valores_Mode( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtvariable_valores_Mode = value ;
   }

   public void setgxTv_Sdtvariable_valores_Mode_SetNull( )
   {
      gxTv_Sdtvariable_valores_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtvariable_valores_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtvariable_valores_Initialized( )
   {
      return gxTv_Sdtvariable_valores_Initialized ;
   }

   public void setgxTv_Sdtvariable_valores_Initialized( short value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtvariable_valores_Initialized = value ;
   }

   public void setgxTv_Sdtvariable_valores_Initialized_SetNull( )
   {
      gxTv_Sdtvariable_valores_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtvariable_valores_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtvariable_valores_Clicod_Z( )
   {
      return gxTv_Sdtvariable_valores_Clicod_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Clicod_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtvariable_valores_Clicod_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Clicod_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtvariable_valores_Opecliid_Z( )
   {
      return gxTv_Sdtvariable_valores_Opecliid_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opecliid_Z( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opecliid_Z");
      gxTv_Sdtvariable_valores_Opecliid_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opecliid_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opecliid_Z = "" ;
      SetDirty("Opecliid_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opecliid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtvariable_valores_Opeclivig_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivig_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivig_Z( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivig_Z");
      gxTv_Sdtvariable_valores_Opeclivig_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivig_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivig_Z = GXutil.nullDate() ;
      SetDirty("Opeclivig_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivig_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivpropagar_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar_Z( boolean value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivpropagar_Z");
      gxTv_Sdtvariable_valores_Opeclivpropagar_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivpropagar_Z = false ;
      SetDirty("Opeclivpropagar_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivpropagar_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtvariable_valores_Opeclivretro_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro_Z( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivretro_Z");
      gxTv_Sdtvariable_valores_Opeclivretro_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivretro_Z = GXutil.nullDate() ;
      SetDirty("Opeclivretro_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivretro_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtvariable_valores_Opeclirelsec_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelsec_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelsec_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclirelsec_Z");
      gxTv_Sdtvariable_valores_Opeclirelsec_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelsec_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclirelsec_Z = 0 ;
      SetDirty("Opeclirelsec_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclirelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtvariable_valores_Opeclirelseccli_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelseccli_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelseccli_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclirelseccli_Z");
      gxTv_Sdtvariable_valores_Opeclirelseccli_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclirelseccli_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclirelseccli_Z = 0 ;
      SetDirty("Opeclirelseccli_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclirelseccli_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtvariable_valores_Opeclivrelref_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivrelref_Z ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivrelref_Z( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivrelref_Z");
      gxTv_Sdtvariable_valores_Opeclivrelref_Z = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivrelref_Z_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivrelref_Z = "" ;
      SetDirty("Opeclivrelref_Z");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivrelref_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtvariable_valores_Opeclivpropagar_N( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar_N ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar_N( byte value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivpropagar_N");
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivpropagar_N_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(0) ;
      SetDirty("Opeclivpropagar_N");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivpropagar_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtvariable_valores_Opeclivretro_N( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro_N ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro_N( byte value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      SetDirty("Opeclivretro_N");
      gxTv_Sdtvariable_valores_Opeclivretro_N = value ;
   }

   public void setgxTv_Sdtvariable_valores_Opeclivretro_N_SetNull( )
   {
      gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(0) ;
      SetDirty("Opeclivretro_N");
   }

   public boolean getgxTv_Sdtvariable_valores_Opeclivretro_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.variable_valores_bc obj;
      obj = new web.variable_valores_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtvariable_valores_N = (byte)(1) ;
      gxTv_Sdtvariable_valores_Opecliid = "" ;
      gxTv_Sdtvariable_valores_Opeclivig = GXutil.nullDate() ;
      gxTv_Sdtvariable_valores_Opeclivalor = "" ;
      gxTv_Sdtvariable_valores_Opeclivretro = GXutil.nullDate() ;
      gxTv_Sdtvariable_valores_Opeclivrelref = "" ;
      gxTv_Sdtvariable_valores_Opeclivold = "" ;
      gxTv_Sdtvariable_valores_Mode = "" ;
      gxTv_Sdtvariable_valores_Opecliid_Z = "" ;
      gxTv_Sdtvariable_valores_Opeclivig_Z = GXutil.nullDate() ;
      gxTv_Sdtvariable_valores_Opeclivretro_Z = GXutil.nullDate() ;
      gxTv_Sdtvariable_valores_Opeclivrelref_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtvariable_valores_N ;
   }

   public web.Sdtvariable_valores Clone( )
   {
      web.Sdtvariable_valores sdt;
      web.variable_valores_bc obj;
      sdt = (web.Sdtvariable_valores)(clone()) ;
      obj = (web.variable_valores_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtvariable_valores struct )
   {
      setgxTv_Sdtvariable_valores_Clicod(struct.getClicod());
      setgxTv_Sdtvariable_valores_Opecliid(struct.getOpecliid());
      setgxTv_Sdtvariable_valores_Opeclivig(struct.getOpeclivig());
      setgxTv_Sdtvariable_valores_Opeclivalor(struct.getOpeclivalor());
      setgxTv_Sdtvariable_valores_Opeclivpropagar(struct.getOpeclivpropagar());
      setgxTv_Sdtvariable_valores_Opeclivretro(struct.getOpeclivretro());
      setgxTv_Sdtvariable_valores_Opeclirelsec(struct.getOpeclirelsec());
      setgxTv_Sdtvariable_valores_Opeclirelseccli(struct.getOpeclirelseccli());
      setgxTv_Sdtvariable_valores_Opeclivrelref(struct.getOpeclivrelref());
      setgxTv_Sdtvariable_valores_Opeclivold(struct.getOpeclivold());
      setgxTv_Sdtvariable_valores_Mode(struct.getMode());
      setgxTv_Sdtvariable_valores_Initialized(struct.getInitialized());
      setgxTv_Sdtvariable_valores_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtvariable_valores_Opecliid_Z(struct.getOpecliid_Z());
      setgxTv_Sdtvariable_valores_Opeclivig_Z(struct.getOpeclivig_Z());
      setgxTv_Sdtvariable_valores_Opeclivpropagar_Z(struct.getOpeclivpropagar_Z());
      setgxTv_Sdtvariable_valores_Opeclivretro_Z(struct.getOpeclivretro_Z());
      setgxTv_Sdtvariable_valores_Opeclirelsec_Z(struct.getOpeclirelsec_Z());
      setgxTv_Sdtvariable_valores_Opeclirelseccli_Z(struct.getOpeclirelseccli_Z());
      setgxTv_Sdtvariable_valores_Opeclivrelref_Z(struct.getOpeclivrelref_Z());
      setgxTv_Sdtvariable_valores_Opeclivpropagar_N(struct.getOpeclivpropagar_N());
      setgxTv_Sdtvariable_valores_Opeclivretro_N(struct.getOpeclivretro_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtvariable_valores getStruct( )
   {
      web.StructSdtvariable_valores struct = new web.StructSdtvariable_valores ();
      struct.setClicod(getgxTv_Sdtvariable_valores_Clicod());
      struct.setOpecliid(getgxTv_Sdtvariable_valores_Opecliid());
      struct.setOpeclivig(getgxTv_Sdtvariable_valores_Opeclivig());
      struct.setOpeclivalor(getgxTv_Sdtvariable_valores_Opeclivalor());
      struct.setOpeclivpropagar(getgxTv_Sdtvariable_valores_Opeclivpropagar());
      struct.setOpeclivretro(getgxTv_Sdtvariable_valores_Opeclivretro());
      struct.setOpeclirelsec(getgxTv_Sdtvariable_valores_Opeclirelsec());
      struct.setOpeclirelseccli(getgxTv_Sdtvariable_valores_Opeclirelseccli());
      struct.setOpeclivrelref(getgxTv_Sdtvariable_valores_Opeclivrelref());
      struct.setOpeclivold(getgxTv_Sdtvariable_valores_Opeclivold());
      struct.setMode(getgxTv_Sdtvariable_valores_Mode());
      struct.setInitialized(getgxTv_Sdtvariable_valores_Initialized());
      struct.setClicod_Z(getgxTv_Sdtvariable_valores_Clicod_Z());
      struct.setOpecliid_Z(getgxTv_Sdtvariable_valores_Opecliid_Z());
      struct.setOpeclivig_Z(getgxTv_Sdtvariable_valores_Opeclivig_Z());
      struct.setOpeclivpropagar_Z(getgxTv_Sdtvariable_valores_Opeclivpropagar_Z());
      struct.setOpeclivretro_Z(getgxTv_Sdtvariable_valores_Opeclivretro_Z());
      struct.setOpeclirelsec_Z(getgxTv_Sdtvariable_valores_Opeclirelsec_Z());
      struct.setOpeclirelseccli_Z(getgxTv_Sdtvariable_valores_Opeclirelseccli_Z());
      struct.setOpeclivrelref_Z(getgxTv_Sdtvariable_valores_Opeclivrelref_Z());
      struct.setOpeclivpropagar_N(getgxTv_Sdtvariable_valores_Opeclivpropagar_N());
      struct.setOpeclivretro_N(getgxTv_Sdtvariable_valores_Opeclivretro_N());
      return struct ;
   }

   private byte gxTv_Sdtvariable_valores_N ;
   private byte gxTv_Sdtvariable_valores_Opeclivpropagar_N ;
   private byte gxTv_Sdtvariable_valores_Opeclivretro_N ;
   private short gxTv_Sdtvariable_valores_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtvariable_valores_Clicod ;
   private int gxTv_Sdtvariable_valores_Opeclirelsec ;
   private int gxTv_Sdtvariable_valores_Opeclirelseccli ;
   private int gxTv_Sdtvariable_valores_Clicod_Z ;
   private int gxTv_Sdtvariable_valores_Opeclirelsec_Z ;
   private int gxTv_Sdtvariable_valores_Opeclirelseccli_Z ;
   private String gxTv_Sdtvariable_valores_Opecliid ;
   private String gxTv_Sdtvariable_valores_Mode ;
   private String gxTv_Sdtvariable_valores_Opecliid_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtvariable_valores_Opeclivig ;
   private java.util.Date gxTv_Sdtvariable_valores_Opeclivretro ;
   private java.util.Date gxTv_Sdtvariable_valores_Opeclivig_Z ;
   private java.util.Date gxTv_Sdtvariable_valores_Opeclivretro_Z ;
   private boolean gxTv_Sdtvariable_valores_Opeclivpropagar ;
   private boolean gxTv_Sdtvariable_valores_Opeclivpropagar_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtvariable_valores_Opeclivalor ;
   private String gxTv_Sdtvariable_valores_Opeclivold ;
   private String gxTv_Sdtvariable_valores_Opeclivrelref ;
   private String gxTv_Sdtvariable_valores_Opeclivrelref_Z ;
}

