package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_liquidacion_lsd extends GxSilentTrnSdt
{
   public Sdtimportacion_liquidacion_lsd( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_liquidacion_lsd.class));
   }

   public Sdtimportacion_liquidacion_lsd( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_liquidacion_lsd");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_liquidacion_lsd( int remoteHandle ,
                                          StructSdtimportacion_liquidacion_lsd struct )
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
                     short AV88ImpLiqSec ,
                     short AV704ImpLiqLSDSec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Short.valueOf(AV88ImpLiqSec),Short.valueOf(AV704ImpLiqLSDSec)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"ImpLiqSec", short.class}, new Object[]{"ImpLiqLSDSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_liquidacion_lsd");
      metadata.set("BT", "importacion_liquidacion_lsd");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\",\"ImpLiqLSDSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtimportacion_liquidacion_lsd_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDSec") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFile") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileName") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileType") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileNameAndType") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDSec_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileName_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileType_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDFileNameAndType_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z = oReader.getValue() ;
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
         sName = "importacion_liquidacion_lsd" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDFile", GXutil.blobToBase64( gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDFileName", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDFileType", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDFileNameAndType", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_liquidacion_lsd_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqLSDSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqLSDFileName_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqLSDFileType_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqLSDFileNameAndType_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_liquidacion_lsd_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_liquidacion_lsd_Empcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSec", gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLSDSec", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLSDFile", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLSDFileName", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLSDFileType", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype, false, includeNonInitialized);
      AddObjectProperty("ImpLiqLSDFileNameAndType", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_liquidacion_lsd_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_liquidacion_lsd_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSec_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqLSDSec_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqLSDFileName_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqLSDFileType_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqLSDFileNameAndType_Z", gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_liquidacion_lsd sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Clicod = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Empcod = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Empcod() ;
      }
      if ( sdt.IsDirty("ImpLiqSec") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec() ;
      }
      if ( sdt.IsDirty("ImpLiqLSDSec") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec() ;
      }
      if ( sdt.IsDirty("ImpLiqLSDFile") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile() ;
      }
      if ( sdt.IsDirty("ImpLiqLSDFileName") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename() ;
      }
      if ( sdt.IsDirty("ImpLiqLSDFileType") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype() ;
      }
      if ( sdt.IsDirty("ImpLiqLSDFileNameAndType") )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype = sdt.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype() ;
      }
   }

   public int getgxTv_Sdtimportacion_liquidacion_lsd_Clicod( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Clicod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Clicod( int value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_lsd_Clicod != value )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_liquidacion_lsd_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Empcod( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Empcod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Empcod( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_lsd_Empcod != value )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_liquidacion_lsd_Empcod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec != value )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_SetNull( );
      }
      SetDirty("Impliqsec");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec != value )
      {
         gxTv_Sdtimportacion_liquidacion_lsd_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_SetNull( );
      }
      SetDirty("Impliqlsdsec");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec = value ;
   }

   @GxUpload
   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfile");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile_SetBlob( String blob ,
                                                                             String fileName ,
                                                                             String fileType )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile = blob ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename = fileName ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype = fileType ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfilename");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfiletype");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfilenameandtype");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Mode( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Mode ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Mode( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_liquidacion_lsd_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Initialized( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Initialized ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Initialized( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_liquidacion_lsd_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqsec_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z = (short)(0) ;
      SetDirty("Impliqsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdsec_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z = (short)(0) ;
      SetDirty("Impliqlsdsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfilename_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z = "" ;
      SetDirty("Impliqlsdfilename_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfiletype_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z = "" ;
      SetDirty("Impliqlsdfiletype_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(0) ;
      SetDirty("Impliqlsdfilenameandtype_Z");
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z = "" ;
      SetDirty("Impliqlsdfilenameandtype_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_liquidacion_lsd_bc obj;
      obj = new web.importacion_liquidacion_lsd_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_liquidacion_lsd_N = (byte)(1) ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Mode = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_liquidacion_lsd_N ;
   }

   public web.Sdtimportacion_liquidacion_lsd Clone( )
   {
      web.Sdtimportacion_liquidacion_lsd sdt;
      web.importacion_liquidacion_lsd_bc obj;
      sdt = (web.Sdtimportacion_liquidacion_lsd)(clone()) ;
      obj = (web.importacion_liquidacion_lsd_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_liquidacion_lsd struct )
   {
      setgxTv_Sdtimportacion_liquidacion_lsd_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_liquidacion_lsd_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec(struct.getImpliqsec());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec(struct.getImpliqlsdsec());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile(struct.getImpliqlsdfile());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename(struct.getImpliqlsdfilename());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype(struct.getImpliqlsdfiletype());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype(struct.getImpliqlsdfilenameandtype());
      setgxTv_Sdtimportacion_liquidacion_lsd_Mode(struct.getMode());
      setgxTv_Sdtimportacion_liquidacion_lsd_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z(struct.getImpliqsec_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z(struct.getImpliqlsdsec_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z(struct.getImpliqlsdfilename_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z(struct.getImpliqlsdfiletype_Z());
      setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z(struct.getImpliqlsdfilenameandtype_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_liquidacion_lsd getStruct( )
   {
      web.StructSdtimportacion_liquidacion_lsd struct = new web.StructSdtimportacion_liquidacion_lsd ();
      struct.setClicod(getgxTv_Sdtimportacion_liquidacion_lsd_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_liquidacion_lsd_Empcod());
      struct.setImpliqsec(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec());
      struct.setImpliqlsdsec(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec());
      struct.setImpliqlsdfile(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile());
      struct.setImpliqlsdfilename(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename());
      struct.setImpliqlsdfiletype(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype());
      struct.setImpliqlsdfilenameandtype(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype());
      struct.setMode(getgxTv_Sdtimportacion_liquidacion_lsd_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_liquidacion_lsd_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z());
      struct.setImpliqsec_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z());
      struct.setImpliqlsdsec_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z());
      struct.setImpliqlsdfilename_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z());
      struct.setImpliqlsdfiletype_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z());
      struct.setImpliqlsdfilenameandtype_Z(getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_liquidacion_lsd_N ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Empcod ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Initialized ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z ;
   private short gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_liquidacion_lsd_Clicod ;
   private int gxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Mode ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z ;
   private String gxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z ;
}

