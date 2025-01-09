package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtarchivo_siradig extends GxSilentTrnSdt
{
   public Sdtarchivo_siradig( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtarchivo_siradig.class));
   }

   public Sdtarchivo_siradig( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtarchivo_siradig");
      initialize( remoteHandle) ;
   }

   public Sdtarchivo_siradig( int remoteHandle ,
                              StructSdtarchivo_siradig struct )
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
                     java.util.Date AV85ArchSiradigFec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),AV85ArchSiradigFec});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"ArchSiradigFec", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "archivo_siradig");
      metadata.set("BT", "archivo_siradig");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"ArchSiradigFec\" ]");
      metadata.set("PKAssigned", "[ \"ArchSiradigFec\" ]");
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
               gxTv_Sdtarchivo_siradig_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtarchivo_siradig_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigFec") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtarchivo_siradig_Archsiradigfec = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_Sdtarchivo_siradig_Archsiradigfec = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigFile") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigfile=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigName") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigType") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigtype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigEstado") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigestado = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigError") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigerror = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSirdigNameAndType") )
            {
               gxTv_Sdtarchivo_siradig_Archsirdignameandtype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtarchivo_siradig_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtarchivo_siradig_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtarchivo_siradig_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtarchivo_siradig_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigFec_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigName_Z") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigType_Z") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigEstado_Z") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigestado_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSiradigError_Z") )
            {
               gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchSirdigNameAndType_Z") )
            {
               gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = oReader.getValue() ;
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
         sName = "archivo_siradig" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtarchivo_siradig_Archsiradigfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ArchSiradigFec", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSiradigFile", GXutil.blobToBase64( gxTv_Sdtarchivo_siradig_Archsiradigfile));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSiradigName", gxTv_Sdtarchivo_siradig_Archsiradigname);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSiradigType", gxTv_Sdtarchivo_siradig_Archsiradigtype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSiradigEstado", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Archsiradigestado, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSiradigError", gxTv_Sdtarchivo_siradig_Archsiradigerror);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ArchSirdigNameAndType", gxTv_Sdtarchivo_siradig_Archsirdignameandtype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtarchivo_siradig_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtarchivo_siradig_Archsiradigfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ArchSiradigFec_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ArchSiradigName_Z", gxTv_Sdtarchivo_siradig_Archsiradigname_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ArchSiradigType_Z", gxTv_Sdtarchivo_siradig_Archsiradigtype_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ArchSiradigEstado_Z", GXutil.trim( GXutil.str( gxTv_Sdtarchivo_siradig_Archsiradigestado_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ArchSiradigError_Z", gxTv_Sdtarchivo_siradig_Archsiradigerror_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ArchSirdigNameAndType_Z", gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtarchivo_siradig_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtarchivo_siradig_Empcod, false, includeNonInitialized);
      datetime_STZ = gxTv_Sdtarchivo_siradig_Archsiradigfec ;
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
      AddObjectProperty("ArchSiradigFec", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ArchSiradigFile", gxTv_Sdtarchivo_siradig_Archsiradigfile, false, includeNonInitialized);
      AddObjectProperty("ArchSiradigName", gxTv_Sdtarchivo_siradig_Archsiradigname, false, includeNonInitialized);
      AddObjectProperty("ArchSiradigType", gxTv_Sdtarchivo_siradig_Archsiradigtype, false, includeNonInitialized);
      AddObjectProperty("ArchSiradigEstado", gxTv_Sdtarchivo_siradig_Archsiradigestado, false, includeNonInitialized);
      AddObjectProperty("ArchSiradigError", gxTv_Sdtarchivo_siradig_Archsiradigerror, false, includeNonInitialized);
      AddObjectProperty("ArchSirdigNameAndType", gxTv_Sdtarchivo_siradig_Archsirdignameandtype, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtarchivo_siradig_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtarchivo_siradig_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtarchivo_siradig_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtarchivo_siradig_Empcod_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_Sdtarchivo_siradig_Archsiradigfec_Z ;
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
         AddObjectProperty("ArchSiradigFec_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ArchSiradigName_Z", gxTv_Sdtarchivo_siradig_Archsiradigname_Z, false, includeNonInitialized);
         AddObjectProperty("ArchSiradigType_Z", gxTv_Sdtarchivo_siradig_Archsiradigtype_Z, false, includeNonInitialized);
         AddObjectProperty("ArchSiradigEstado_Z", gxTv_Sdtarchivo_siradig_Archsiradigestado_Z, false, includeNonInitialized);
         AddObjectProperty("ArchSiradigError_Z", gxTv_Sdtarchivo_siradig_Archsiradigerror_Z, false, includeNonInitialized);
         AddObjectProperty("ArchSirdigNameAndType_Z", gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtarchivo_siradig sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Clicod = sdt.getgxTv_Sdtarchivo_siradig_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Empcod = sdt.getgxTv_Sdtarchivo_siradig_Empcod() ;
      }
      if ( sdt.IsDirty("ArchSiradigFec") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigfec = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigfec() ;
      }
      if ( sdt.IsDirty("ArchSiradigFile") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigfile = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigfile() ;
      }
      if ( sdt.IsDirty("ArchSiradigName") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigname = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigname() ;
      }
      if ( sdt.IsDirty("ArchSiradigType") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigtype = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigtype() ;
      }
      if ( sdt.IsDirty("ArchSiradigEstado") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigestado = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigestado() ;
      }
      if ( sdt.IsDirty("ArchSiradigError") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsiradigerror = sdt.getgxTv_Sdtarchivo_siradig_Archsiradigerror() ;
      }
      if ( sdt.IsDirty("ArchSirdigNameAndType") )
      {
         gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
         gxTv_Sdtarchivo_siradig_Archsirdignameandtype = sdt.getgxTv_Sdtarchivo_siradig_Archsirdignameandtype() ;
      }
   }

   public int getgxTv_Sdtarchivo_siradig_Clicod( )
   {
      return gxTv_Sdtarchivo_siradig_Clicod ;
   }

   public void setgxTv_Sdtarchivo_siradig_Clicod( int value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      if ( gxTv_Sdtarchivo_siradig_Clicod != value )
      {
         gxTv_Sdtarchivo_siradig_Mode = "INS" ;
         this.setgxTv_Sdtarchivo_siradig_Clicod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Empcod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigname_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtarchivo_siradig_Clicod = value ;
   }

   public short getgxTv_Sdtarchivo_siradig_Empcod( )
   {
      return gxTv_Sdtarchivo_siradig_Empcod ;
   }

   public void setgxTv_Sdtarchivo_siradig_Empcod( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      if ( gxTv_Sdtarchivo_siradig_Empcod != value )
      {
         gxTv_Sdtarchivo_siradig_Mode = "INS" ;
         this.setgxTv_Sdtarchivo_siradig_Clicod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Empcod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigname_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtarchivo_siradig_Empcod = value ;
   }

   public java.util.Date getgxTv_Sdtarchivo_siradig_Archsiradigfec( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfec ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigfec( java.util.Date value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(gxTv_Sdtarchivo_siradig_Archsiradigfec, value) ) )
      {
         gxTv_Sdtarchivo_siradig_Mode = "INS" ;
         this.setgxTv_Sdtarchivo_siradig_Clicod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Empcod_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigname_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z_SetNull( );
         this.setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z_SetNull( );
      }
      SetDirty("Archsiradigfec");
      gxTv_Sdtarchivo_siradig_Archsiradigfec = value ;
   }

   @GxUpload
   public String getgxTv_Sdtarchivo_siradig_Archsiradigfile( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfile ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigfile( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigfile");
      gxTv_Sdtarchivo_siradig_Archsiradigfile = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigfile_SetBlob( String blob ,
                                                                   String fileName ,
                                                                   String fileType )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigfile = blob ;
      gxTv_Sdtarchivo_siradig_Archsiradigname = fileName ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype = fileType ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigname( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigname ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigname( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigname");
      gxTv_Sdtarchivo_siradig_Archsiradigname = value ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigtype( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigtype ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigtype( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigtype");
      gxTv_Sdtarchivo_siradig_Archsiradigtype = value ;
   }

   public short getgxTv_Sdtarchivo_siradig_Archsiradigestado( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigestado ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigestado( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigestado");
      gxTv_Sdtarchivo_siradig_Archsiradigestado = value ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigerror( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigerror ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigerror( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigerror");
      gxTv_Sdtarchivo_siradig_Archsiradigerror = value ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsirdignameandtype( )
   {
      return gxTv_Sdtarchivo_siradig_Archsirdignameandtype ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsirdignameandtype( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsirdignameandtype");
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype = "" ;
      SetDirty("Archsirdignameandtype");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsirdignameandtype_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtarchivo_siradig_Mode( )
   {
      return gxTv_Sdtarchivo_siradig_Mode ;
   }

   public void setgxTv_Sdtarchivo_siradig_Mode( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtarchivo_siradig_Mode = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Mode_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtarchivo_siradig_Initialized( )
   {
      return gxTv_Sdtarchivo_siradig_Initialized ;
   }

   public void setgxTv_Sdtarchivo_siradig_Initialized( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtarchivo_siradig_Initialized = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Initialized_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtarchivo_siradig_Clicod_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Clicod_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Clicod_Z( int value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtarchivo_siradig_Clicod_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Clicod_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtarchivo_siradig_Empcod_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Empcod_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Empcod_Z( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtarchivo_siradig_Empcod_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Empcod_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtarchivo_siradig_Archsiradigfec_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfec_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z( java.util.Date value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigfec_Z");
      gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Archsiradigfec_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsiradigfec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigname_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigname_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigname_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigname_Z");
      gxTv_Sdtarchivo_siradig_Archsiradigname_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigname_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigname_Z = "" ;
      SetDirty("Archsiradigname_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsiradigname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigtype_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigtype_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigtype_Z");
      gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = "" ;
      SetDirty("Archsiradigtype_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsiradigtype_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtarchivo_siradig_Archsiradigestado_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigestado_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigestado_Z");
      gxTv_Sdtarchivo_siradig_Archsiradigestado_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigestado_Z = (short)(0) ;
      SetDirty("Archsiradigestado_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsiradigestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsiradigerror_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigerror_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsiradigerror_Z");
      gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = "" ;
      SetDirty("Archsiradigerror_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsiradigerror_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      SetDirty("Archsirdignameandtype_Z");
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = value ;
   }

   public void setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z_SetNull( )
   {
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = "" ;
      SetDirty("Archsirdignameandtype_Z");
   }

   public boolean getgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.archivo_siradig_bc obj;
      obj = new web.archivo_siradig_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(1) ;
      gxTv_Sdtarchivo_siradig_Archsiradigfec = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtarchivo_siradig_Archsiradigfile = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigname = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror = "" ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype = "" ;
      gxTv_Sdtarchivo_siradig_Mode = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtarchivo_siradig_Archsiradigname_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtarchivo_siradig_N ;
   }

   public web.Sdtarchivo_siradig Clone( )
   {
      web.Sdtarchivo_siradig sdt;
      web.archivo_siradig_bc obj;
      sdt = (web.Sdtarchivo_siradig)(clone()) ;
      obj = (web.archivo_siradig_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtarchivo_siradig struct )
   {
      setgxTv_Sdtarchivo_siradig_Clicod(struct.getClicod());
      setgxTv_Sdtarchivo_siradig_Empcod(struct.getEmpcod());
      setgxTv_Sdtarchivo_siradig_Archsiradigfec(struct.getArchsiradigfec());
      setgxTv_Sdtarchivo_siradig_Archsiradigfile(struct.getArchsiradigfile());
      setgxTv_Sdtarchivo_siradig_Archsiradigname(struct.getArchsiradigname());
      setgxTv_Sdtarchivo_siradig_Archsiradigtype(struct.getArchsiradigtype());
      setgxTv_Sdtarchivo_siradig_Archsiradigestado(struct.getArchsiradigestado());
      setgxTv_Sdtarchivo_siradig_Archsiradigerror(struct.getArchsiradigerror());
      setgxTv_Sdtarchivo_siradig_Archsirdignameandtype(struct.getArchsirdignameandtype());
      setgxTv_Sdtarchivo_siradig_Mode(struct.getMode());
      setgxTv_Sdtarchivo_siradig_Initialized(struct.getInitialized());
      setgxTv_Sdtarchivo_siradig_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtarchivo_siradig_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z(struct.getArchsiradigfec_Z());
      setgxTv_Sdtarchivo_siradig_Archsiradigname_Z(struct.getArchsiradigname_Z());
      setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z(struct.getArchsiradigtype_Z());
      setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z(struct.getArchsiradigestado_Z());
      setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z(struct.getArchsiradigerror_Z());
      setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z(struct.getArchsirdignameandtype_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtarchivo_siradig getStruct( )
   {
      web.StructSdtarchivo_siradig struct = new web.StructSdtarchivo_siradig ();
      struct.setClicod(getgxTv_Sdtarchivo_siradig_Clicod());
      struct.setEmpcod(getgxTv_Sdtarchivo_siradig_Empcod());
      struct.setArchsiradigfec(getgxTv_Sdtarchivo_siradig_Archsiradigfec());
      struct.setArchsiradigfile(getgxTv_Sdtarchivo_siradig_Archsiradigfile());
      struct.setArchsiradigname(getgxTv_Sdtarchivo_siradig_Archsiradigname());
      struct.setArchsiradigtype(getgxTv_Sdtarchivo_siradig_Archsiradigtype());
      struct.setArchsiradigestado(getgxTv_Sdtarchivo_siradig_Archsiradigestado());
      struct.setArchsiradigerror(getgxTv_Sdtarchivo_siradig_Archsiradigerror());
      struct.setArchsirdignameandtype(getgxTv_Sdtarchivo_siradig_Archsirdignameandtype());
      struct.setMode(getgxTv_Sdtarchivo_siradig_Mode());
      struct.setInitialized(getgxTv_Sdtarchivo_siradig_Initialized());
      struct.setClicod_Z(getgxTv_Sdtarchivo_siradig_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtarchivo_siradig_Empcod_Z());
      struct.setArchsiradigfec_Z(getgxTv_Sdtarchivo_siradig_Archsiradigfec_Z());
      struct.setArchsiradigname_Z(getgxTv_Sdtarchivo_siradig_Archsiradigname_Z());
      struct.setArchsiradigtype_Z(getgxTv_Sdtarchivo_siradig_Archsiradigtype_Z());
      struct.setArchsiradigestado_Z(getgxTv_Sdtarchivo_siradig_Archsiradigestado_Z());
      struct.setArchsiradigerror_Z(getgxTv_Sdtarchivo_siradig_Archsiradigerror_Z());
      struct.setArchsirdignameandtype_Z(getgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z());
      return struct ;
   }

   private byte gxTv_Sdtarchivo_siradig_N ;
   private short gxTv_Sdtarchivo_siradig_Empcod ;
   private short gxTv_Sdtarchivo_siradig_Archsiradigestado ;
   private short gxTv_Sdtarchivo_siradig_Initialized ;
   private short gxTv_Sdtarchivo_siradig_Empcod_Z ;
   private short gxTv_Sdtarchivo_siradig_Archsiradigestado_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtarchivo_siradig_Clicod ;
   private int gxTv_Sdtarchivo_siradig_Clicod_Z ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigtype ;
   private String gxTv_Sdtarchivo_siradig_Mode ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigtype_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtarchivo_siradig_Archsiradigfec ;
   private java.util.Date gxTv_Sdtarchivo_siradig_Archsiradigfec_Z ;
   private java.util.Date datetime_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigfile ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigname ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigerror ;
   private String gxTv_Sdtarchivo_siradig_Archsirdignameandtype ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigname_Z ;
   private String gxTv_Sdtarchivo_siradig_Archsiradigerror_Z ;
   private String gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z ;
}

