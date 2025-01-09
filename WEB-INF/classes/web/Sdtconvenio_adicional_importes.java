package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconvenio_adicional_importes extends GxSilentTrnSdt
{
   public Sdtconvenio_adicional_importes( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtconvenio_adicional_importes.class));
   }

   public Sdtconvenio_adicional_importes( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtconvenio_adicional_importes");
      initialize( remoteHandle) ;
   }

   public Sdtconvenio_adicional_importes( int remoteHandle ,
                                          StructSdtconvenio_adicional_importes struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public Sdtconvenio_adicional_importes( )
   {
      super( new ModelContext(Sdtconvenio_adicional_importes.class), "Sdtconvenio_adicional_importes");
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
      return (Object[][])(new Object[][]{new Object[]{"ConveAdiVig", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importes");
      metadata.set("BT", "convenio_adicionalimportes");
      metadata.set("PK", "[ \"ConveAdiVig\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"ConveAdicod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtconvenio_adicional_importes_Conveadivig = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtconvenio_adicional_importes_Conveadivig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiImporte") )
            {
               gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiImpRelSec") )
            {
               gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtconvenio_adicional_importes_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_Sdtconvenio_adicional_importes_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtconvenio_adicional_importes_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiVig_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiImporte_Z") )
            {
               gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiImpRelSec_Z") )
            {
               gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "convenio_adicional.importes" ;
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
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ConveAdiVig", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiImporte", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_importes_Conveadiimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiImpRelSec", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtconvenio_adicional_importes_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_importes_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_importes_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ConveAdiVig_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiImporte_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiImpRelSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z, 6, 0)));
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
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtconvenio_adicional_importes_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ConveAdiVig", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ConveAdiImporte", gxTv_Sdtconvenio_adicional_importes_Conveadiimporte, false, includeNonInitialized);
      AddObjectProperty("ConveAdiImpRelSec", gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtconvenio_adicional_importes_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_Sdtconvenio_adicional_importes_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtconvenio_adicional_importes_Initialized, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ConveAdiVig_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ConveAdiImporte_Z", gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiImpRelSec_Z", gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtconvenio_adicional_importes sdt )
   {
      if ( sdt.IsDirty("ConveAdiVig") )
      {
         gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_importes_Conveadivig = sdt.getgxTv_Sdtconvenio_adicional_importes_Conveadivig() ;
      }
      if ( sdt.IsDirty("ConveAdiImporte") )
      {
         gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = sdt.getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte() ;
      }
      if ( sdt.IsDirty("ConveAdiImpRelSec") )
      {
         gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec = sdt.getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec() ;
      }
   }

   public java.util.Date getgxTv_Sdtconvenio_adicional_importes_Conveadivig( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadivig ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadivig( java.util.Date value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadivig");
      gxTv_Sdtconvenio_adicional_importes_Conveadivig = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimporte ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadiimporte");
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = value ;
   }

   public int getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadiimprelsec");
      gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_importes_Mode( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Mode ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Mode( String value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtconvenio_adicional_importes_Mode = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Mode_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_importes_Modified( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Modified ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Modified( short value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_Sdtconvenio_adicional_importes_Modified = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Modified_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_importes_Initialized( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Initialized ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Initialized( short value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_Sdtconvenio_adicional_importes_Initialized = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Initialized_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Initialized_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z( java.util.Date value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadivig_Z");
      gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = GXutil.nullDate() ;
      SetDirty("Conveadivig_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadiimporte_Z");
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = DecimalUtil.ZERO ;
      SetDirty("Conveadiimporte_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = (short)(1) ;
      SetDirty("Conveadiimprelsec_Z");
      gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z = 0 ;
      SetDirty("Conveadiimprelsec_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtconvenio_adicional_importes_Conveadivig = GXutil.nullDate() ;
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_adicional_importes_Mode = "" ;
      gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = GXutil.nullDate() ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconvenio_adicional_importes_N ;
   }

   public web.Sdtconvenio_adicional_importes Clone( )
   {
      return (web.Sdtconvenio_adicional_importes)(clone()) ;
   }

   public void setStruct( web.StructSdtconvenio_adicional_importes struct )
   {
      setgxTv_Sdtconvenio_adicional_importes_Conveadivig(struct.getConveadivig());
      setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte(struct.getConveadiimporte());
      setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec(struct.getConveadiimprelsec());
      setgxTv_Sdtconvenio_adicional_importes_Mode(struct.getMode());
      setgxTv_Sdtconvenio_adicional_importes_Modified(struct.getModified());
      setgxTv_Sdtconvenio_adicional_importes_Initialized(struct.getInitialized());
      setgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z(struct.getConveadivig_Z());
      setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z(struct.getConveadiimporte_Z());
      setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z(struct.getConveadiimprelsec_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconvenio_adicional_importes getStruct( )
   {
      web.StructSdtconvenio_adicional_importes struct = new web.StructSdtconvenio_adicional_importes ();
      struct.setConveadivig(getgxTv_Sdtconvenio_adicional_importes_Conveadivig());
      struct.setConveadiimporte(getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte());
      struct.setConveadiimprelsec(getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec());
      struct.setMode(getgxTv_Sdtconvenio_adicional_importes_Mode());
      struct.setModified(getgxTv_Sdtconvenio_adicional_importes_Modified());
      struct.setInitialized(getgxTv_Sdtconvenio_adicional_importes_Initialized());
      struct.setConveadivig_Z(getgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z());
      struct.setConveadiimporte_Z(getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z());
      struct.setConveadiimprelsec_Z(getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z());
      return struct ;
   }

   private byte gxTv_Sdtconvenio_adicional_importes_N ;
   private short gxTv_Sdtconvenio_adicional_importes_Modified ;
   private short gxTv_Sdtconvenio_adicional_importes_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec ;
   private int gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_importes_Conveadiimporte ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z ;
   private String gxTv_Sdtconvenio_adicional_importes_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtconvenio_adicional_importes_Conveadivig ;
   private java.util.Date gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

