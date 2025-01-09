package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo_Propiedades extends GxSilentTrnSdt
{
   public SdtLegajo_Propiedades( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo_Propiedades.class));
   }

   public SdtLegajo_Propiedades( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo_Propiedades");
      initialize( remoteHandle) ;
   }

   public SdtLegajo_Propiedades( int remoteHandle ,
                                 StructSdtLegajo_Propiedades struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtLegajo_Propiedades( )
   {
      super( new ModelContext(SdtLegajo_Propiedades.class), "SdtLegajo_Propiedades");
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
      return (Object[][])(new Object[][]{new Object[]{"LegPropCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Propiedades");
      metadata.set("BT", "LegajoPropiedades");
      metadata.set("PK", "[ \"LegPropCod\" ]");
      metadata.set("PKAssigned", "[ \"LegPropCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"propCod\" ],\"FKMap\":[ \"LegPropCod-propCod\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropCod") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropDes") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropdes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropTD") )
            {
               gxTv_SdtLegajo_Propiedades_Legproptd = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValNum") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalnum = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValBool") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalbool = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValStr") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalstr = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValDate") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Propiedades_Legpropvaldate = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Propiedades_Legpropvaldate = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtLegajo_Propiedades_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtLegajo_Propiedades_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_Propiedades_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropCod_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropDes_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropdes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropTD_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legproptd_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValNum_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValBool_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValStr_Z") )
            {
               gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegPropValDate_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
         sName = "Legajo.Propiedades" ;
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
      oWriter.writeElement("LegPropCod", gxTv_SdtLegajo_Propiedades_Legpropcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPropDes", gxTv_SdtLegajo_Propiedades_Legpropdes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPropTD", gxTv_SdtLegajo_Propiedades_Legproptd);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPropValNum", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Propiedades_Legpropvalnum, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPropValBool", GXutil.booltostr( gxTv_SdtLegajo_Propiedades_Legpropvalbool));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegPropValStr", gxTv_SdtLegajo_Propiedades_Legpropvalstr);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegPropValDate", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_Propiedades_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Propiedades_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Propiedades_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropCod_Z", gxTv_SdtLegajo_Propiedades_Legpropcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropDes_Z", gxTv_SdtLegajo_Propiedades_Legpropdes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropTD_Z", gxTv_SdtLegajo_Propiedades_Legproptd_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropValNum_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropValBool_Z", GXutil.booltostr( gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegPropValStr_Z", gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegPropValDate_Z", sDateCnv);
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
      AddObjectProperty("LegPropCod", gxTv_SdtLegajo_Propiedades_Legpropcod, false, includeNonInitialized);
      AddObjectProperty("LegPropDes", gxTv_SdtLegajo_Propiedades_Legpropdes, false, includeNonInitialized);
      AddObjectProperty("LegPropTD", gxTv_SdtLegajo_Propiedades_Legproptd, false, includeNonInitialized);
      AddObjectProperty("LegPropValNum", gxTv_SdtLegajo_Propiedades_Legpropvalnum, false, includeNonInitialized);
      AddObjectProperty("LegPropValBool", gxTv_SdtLegajo_Propiedades_Legpropvalbool, false, includeNonInitialized);
      AddObjectProperty("LegPropValStr", gxTv_SdtLegajo_Propiedades_Legpropvalstr, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Propiedades_Legpropvaldate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegPropValDate", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_Propiedades_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtLegajo_Propiedades_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_Propiedades_Initialized, false, includeNonInitialized);
         AddObjectProperty("LegPropCod_Z", gxTv_SdtLegajo_Propiedades_Legpropcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegPropDes_Z", gxTv_SdtLegajo_Propiedades_Legpropdes_Z, false, includeNonInitialized);
         AddObjectProperty("LegPropTD_Z", gxTv_SdtLegajo_Propiedades_Legproptd_Z, false, includeNonInitialized);
         AddObjectProperty("LegPropValNum_Z", gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z, false, includeNonInitialized);
         AddObjectProperty("LegPropValBool_Z", gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z, false, includeNonInitialized);
         AddObjectProperty("LegPropValStr_Z", gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegPropValDate_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo_Propiedades sdt )
   {
      if ( sdt.IsDirty("LegPropCod") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropcod = sdt.getgxTv_SdtLegajo_Propiedades_Legpropcod() ;
      }
      if ( sdt.IsDirty("LegPropDes") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropdes = sdt.getgxTv_SdtLegajo_Propiedades_Legpropdes() ;
      }
      if ( sdt.IsDirty("LegPropTD") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legproptd = sdt.getgxTv_SdtLegajo_Propiedades_Legproptd() ;
      }
      if ( sdt.IsDirty("LegPropValNum") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropvalnum = sdt.getgxTv_SdtLegajo_Propiedades_Legpropvalnum() ;
      }
      if ( sdt.IsDirty("LegPropValBool") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropvalbool = sdt.getgxTv_SdtLegajo_Propiedades_Legpropvalbool() ;
      }
      if ( sdt.IsDirty("LegPropValStr") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropvalstr = sdt.getgxTv_SdtLegajo_Propiedades_Legpropvalstr() ;
      }
      if ( sdt.IsDirty("LegPropValDate") )
      {
         gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
         gxTv_SdtLegajo_Propiedades_Legpropvaldate = sdt.getgxTv_SdtLegajo_Propiedades_Legpropvaldate() ;
      }
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropcod( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropcod ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropcod( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropcod");
      gxTv_SdtLegajo_Propiedades_Legpropcod = value ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropdes( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropdes ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropdes( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropdes");
      gxTv_SdtLegajo_Propiedades_Legpropdes = value ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legproptd( )
   {
      return gxTv_SdtLegajo_Propiedades_Legproptd ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legproptd( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legproptd");
      gxTv_SdtLegajo_Propiedades_Legproptd = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Propiedades_Legpropvalnum( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalnum ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalnum( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalnum");
      gxTv_SdtLegajo_Propiedades_Legpropvalnum = value ;
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvalbool( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalbool ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalbool( boolean value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalbool");
      gxTv_SdtLegajo_Propiedades_Legpropvalbool = value ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropvalstr( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalstr ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalstr( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalstr");
      gxTv_SdtLegajo_Propiedades_Legpropvalstr = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Propiedades_Legpropvaldate( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvaldate ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvaldate( java.util.Date value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvaldate");
      gxTv_SdtLegajo_Propiedades_Legpropvaldate = value ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Mode( )
   {
      return gxTv_SdtLegajo_Propiedades_Mode ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Mode( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_Propiedades_Mode = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Mode_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Propiedades_Modified( )
   {
      return gxTv_SdtLegajo_Propiedades_Modified ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Modified( short value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtLegajo_Propiedades_Modified = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Modified_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Propiedades_Initialized( )
   {
      return gxTv_SdtLegajo_Propiedades_Initialized ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Initialized( short value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_Propiedades_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropcod_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropcod_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropcod_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropcod_Z");
      gxTv_SdtLegajo_Propiedades_Legpropcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropcod_Z = "" ;
      SetDirty("Legpropcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropdes_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropdes_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropdes_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropdes_Z");
      gxTv_SdtLegajo_Propiedades_Legpropdes_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropdes_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropdes_Z = "" ;
      SetDirty("Legpropdes_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropdes_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legproptd_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legproptd_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legproptd_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legproptd_Z");
      gxTv_SdtLegajo_Propiedades_Legproptd_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legproptd_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legproptd_Z = "" ;
      SetDirty("Legproptd_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legproptd_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalnum_Z");
      gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = DecimalUtil.ZERO ;
      SetDirty("Legpropvalnum_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z( boolean value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalbool_Z");
      gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z = false ;
      SetDirty("Legpropvalbool_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvalstr_Z");
      gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = "" ;
      SetDirty("Legpropvalstr_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = (short)(1) ;
      SetDirty("Legpropvaldate_Z");
      gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = value ;
   }

   public void setgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z_SetNull( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = GXutil.nullDate() ;
      SetDirty("Legpropvaldate_Z");
   }

   public boolean getgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_Propiedades_Legpropcod = "" ;
      gxTv_SdtLegajo_Propiedades_N = (byte)(1) ;
      gxTv_SdtLegajo_Propiedades_Legpropdes = "" ;
      gxTv_SdtLegajo_Propiedades_Legproptd = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate = GXutil.nullDate() ;
      gxTv_SdtLegajo_Propiedades_Mode = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropcod_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropdes_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legproptd_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_Propiedades_N ;
   }

   public web.SdtLegajo_Propiedades Clone( )
   {
      return (web.SdtLegajo_Propiedades)(clone()) ;
   }

   public void setStruct( web.StructSdtLegajo_Propiedades struct )
   {
      setgxTv_SdtLegajo_Propiedades_Legpropcod(struct.getLegpropcod());
      setgxTv_SdtLegajo_Propiedades_Legpropdes(struct.getLegpropdes());
      setgxTv_SdtLegajo_Propiedades_Legproptd(struct.getLegproptd());
      setgxTv_SdtLegajo_Propiedades_Legpropvalnum(struct.getLegpropvalnum());
      setgxTv_SdtLegajo_Propiedades_Legpropvalbool(struct.getLegpropvalbool());
      setgxTv_SdtLegajo_Propiedades_Legpropvalstr(struct.getLegpropvalstr());
      setgxTv_SdtLegajo_Propiedades_Legpropvaldate(struct.getLegpropvaldate());
      setgxTv_SdtLegajo_Propiedades_Mode(struct.getMode());
      setgxTv_SdtLegajo_Propiedades_Modified(struct.getModified());
      setgxTv_SdtLegajo_Propiedades_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_Propiedades_Legpropcod_Z(struct.getLegpropcod_Z());
      setgxTv_SdtLegajo_Propiedades_Legpropdes_Z(struct.getLegpropdes_Z());
      setgxTv_SdtLegajo_Propiedades_Legproptd_Z(struct.getLegproptd_Z());
      setgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z(struct.getLegpropvalnum_Z());
      setgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z(struct.getLegpropvalbool_Z());
      setgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z(struct.getLegpropvalstr_Z());
      setgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z(struct.getLegpropvaldate_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo_Propiedades getStruct( )
   {
      web.StructSdtLegajo_Propiedades struct = new web.StructSdtLegajo_Propiedades ();
      struct.setLegpropcod(getgxTv_SdtLegajo_Propiedades_Legpropcod());
      struct.setLegpropdes(getgxTv_SdtLegajo_Propiedades_Legpropdes());
      struct.setLegproptd(getgxTv_SdtLegajo_Propiedades_Legproptd());
      struct.setLegpropvalnum(getgxTv_SdtLegajo_Propiedades_Legpropvalnum());
      struct.setLegpropvalbool(getgxTv_SdtLegajo_Propiedades_Legpropvalbool());
      struct.setLegpropvalstr(getgxTv_SdtLegajo_Propiedades_Legpropvalstr());
      struct.setLegpropvaldate(getgxTv_SdtLegajo_Propiedades_Legpropvaldate());
      struct.setMode(getgxTv_SdtLegajo_Propiedades_Mode());
      struct.setModified(getgxTv_SdtLegajo_Propiedades_Modified());
      struct.setInitialized(getgxTv_SdtLegajo_Propiedades_Initialized());
      struct.setLegpropcod_Z(getgxTv_SdtLegajo_Propiedades_Legpropcod_Z());
      struct.setLegpropdes_Z(getgxTv_SdtLegajo_Propiedades_Legpropdes_Z());
      struct.setLegproptd_Z(getgxTv_SdtLegajo_Propiedades_Legproptd_Z());
      struct.setLegpropvalnum_Z(getgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z());
      struct.setLegpropvalbool_Z(getgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z());
      struct.setLegpropvalstr_Z(getgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z());
      struct.setLegpropvaldate_Z(getgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z());
      return struct ;
   }

   private byte gxTv_SdtLegajo_Propiedades_N ;
   private short gxTv_SdtLegajo_Propiedades_Modified ;
   private short gxTv_SdtLegajo_Propiedades_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtLegajo_Propiedades_Legpropvalnum ;
   private java.math.BigDecimal gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z ;
   private String gxTv_SdtLegajo_Propiedades_Legpropcod ;
   private String gxTv_SdtLegajo_Propiedades_Legproptd ;
   private String gxTv_SdtLegajo_Propiedades_Mode ;
   private String gxTv_SdtLegajo_Propiedades_Legpropcod_Z ;
   private String gxTv_SdtLegajo_Propiedades_Legproptd_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajo_Propiedades_Legpropvaldate ;
   private java.util.Date gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z ;
   private boolean gxTv_SdtLegajo_Propiedades_Legpropvalbool ;
   private boolean gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajo_Propiedades_Legpropdes ;
   private String gxTv_SdtLegajo_Propiedades_Legpropvalstr ;
   private String gxTv_SdtLegajo_Propiedades_Legpropdes_Z ;
   private String gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z ;
}

