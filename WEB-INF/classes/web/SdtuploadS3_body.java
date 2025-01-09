package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtuploadS3_body extends GxUserType
{
   public SdtuploadS3_body( )
   {
      this(  new ModelContext(SdtuploadS3_body.class));
   }

   public SdtuploadS3_body( ModelContext context )
   {
      super( context, "SdtuploadS3_body");
   }

   public SdtuploadS3_body( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtuploadS3_body");
   }

   public SdtuploadS3_body( StructSdtuploadS3_body struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "bucket_name") )
            {
               gxTv_SdtuploadS3_body_Bucket_name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "file_path") )
            {
               gxTv_SdtuploadS3_body_File_path = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "s3_path") )
            {
               gxTv_SdtuploadS3_body_S3_path = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "file_name") )
            {
               gxTv_SdtuploadS3_body_File_name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "content_type") )
            {
               gxTv_SdtuploadS3_body_Content_type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aws_region") )
            {
               gxTv_SdtuploadS3_body_Aws_region = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "htmlContent") )
            {
               gxTv_SdtuploadS3_body_Htmlcontent = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "clicod") )
            {
               gxTv_SdtuploadS3_body_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "empcod") )
            {
               gxTv_SdtuploadS3_body_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "liqnro") )
            {
               gxTv_SdtuploadS3_body_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "linklegnumero") )
            {
               gxTv_SdtuploadS3_body_Linklegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "leglinktiporec") )
            {
               gxTv_SdtuploadS3_body_Leglinktiporec = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "uploadHTML") )
            {
               gxTv_SdtuploadS3_body_Uploadhtml = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "uploadS3_body" ;
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
      oWriter.writeElement("bucket_name", gxTv_SdtuploadS3_body_Bucket_name);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("file_path", gxTv_SdtuploadS3_body_File_path);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("s3_path", gxTv_SdtuploadS3_body_S3_path);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("file_name", gxTv_SdtuploadS3_body_File_name);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("content_type", gxTv_SdtuploadS3_body_Content_type);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("aws_region", gxTv_SdtuploadS3_body_Aws_region);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("htmlContent", gxTv_SdtuploadS3_body_Htmlcontent);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("clicod", GXutil.trim( GXutil.str( gxTv_SdtuploadS3_body_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("empcod", GXutil.trim( GXutil.str( gxTv_SdtuploadS3_body_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("liqnro", GXutil.trim( GXutil.str( gxTv_SdtuploadS3_body_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("linklegnumero", GXutil.trim( GXutil.str( gxTv_SdtuploadS3_body_Linklegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("leglinktiporec", gxTv_SdtuploadS3_body_Leglinktiporec);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("uploadHTML", GXutil.booltostr( gxTv_SdtuploadS3_body_Uploadhtml));
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
      AddObjectProperty("bucket_name", gxTv_SdtuploadS3_body_Bucket_name, false, false);
      AddObjectProperty("file_path", gxTv_SdtuploadS3_body_File_path, false, false);
      AddObjectProperty("s3_path", gxTv_SdtuploadS3_body_S3_path, false, false);
      AddObjectProperty("file_name", gxTv_SdtuploadS3_body_File_name, false, false);
      AddObjectProperty("content_type", gxTv_SdtuploadS3_body_Content_type, false, false);
      AddObjectProperty("aws_region", gxTv_SdtuploadS3_body_Aws_region, false, false);
      AddObjectProperty("htmlContent", gxTv_SdtuploadS3_body_Htmlcontent, false, false);
      AddObjectProperty("clicod", gxTv_SdtuploadS3_body_Clicod, false, false);
      AddObjectProperty("empcod", gxTv_SdtuploadS3_body_Empcod, false, false);
      AddObjectProperty("liqnro", gxTv_SdtuploadS3_body_Liqnro, false, false);
      AddObjectProperty("linklegnumero", gxTv_SdtuploadS3_body_Linklegnumero, false, false);
      AddObjectProperty("leglinktiporec", gxTv_SdtuploadS3_body_Leglinktiporec, false, false);
      AddObjectProperty("uploadHTML", gxTv_SdtuploadS3_body_Uploadhtml, false, false);
   }

   public String getgxTv_SdtuploadS3_body_Bucket_name( )
   {
      return gxTv_SdtuploadS3_body_Bucket_name ;
   }

   public void setgxTv_SdtuploadS3_body_Bucket_name( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Bucket_name = value ;
   }

   public String getgxTv_SdtuploadS3_body_File_path( )
   {
      return gxTv_SdtuploadS3_body_File_path ;
   }

   public void setgxTv_SdtuploadS3_body_File_path( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_File_path = value ;
   }

   public String getgxTv_SdtuploadS3_body_S3_path( )
   {
      return gxTv_SdtuploadS3_body_S3_path ;
   }

   public void setgxTv_SdtuploadS3_body_S3_path( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_S3_path = value ;
   }

   public String getgxTv_SdtuploadS3_body_File_name( )
   {
      return gxTv_SdtuploadS3_body_File_name ;
   }

   public void setgxTv_SdtuploadS3_body_File_name( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_File_name = value ;
   }

   public String getgxTv_SdtuploadS3_body_Content_type( )
   {
      return gxTv_SdtuploadS3_body_Content_type ;
   }

   public void setgxTv_SdtuploadS3_body_Content_type( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Content_type = value ;
   }

   public String getgxTv_SdtuploadS3_body_Aws_region( )
   {
      return gxTv_SdtuploadS3_body_Aws_region ;
   }

   public void setgxTv_SdtuploadS3_body_Aws_region( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Aws_region = value ;
   }

   public String getgxTv_SdtuploadS3_body_Htmlcontent( )
   {
      return gxTv_SdtuploadS3_body_Htmlcontent ;
   }

   public void setgxTv_SdtuploadS3_body_Htmlcontent( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Htmlcontent = value ;
   }

   public int getgxTv_SdtuploadS3_body_Clicod( )
   {
      return gxTv_SdtuploadS3_body_Clicod ;
   }

   public void setgxTv_SdtuploadS3_body_Clicod( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Clicod = value ;
   }

   public short getgxTv_SdtuploadS3_body_Empcod( )
   {
      return gxTv_SdtuploadS3_body_Empcod ;
   }

   public void setgxTv_SdtuploadS3_body_Empcod( short value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Empcod = value ;
   }

   public int getgxTv_SdtuploadS3_body_Liqnro( )
   {
      return gxTv_SdtuploadS3_body_Liqnro ;
   }

   public void setgxTv_SdtuploadS3_body_Liqnro( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Liqnro = value ;
   }

   public int getgxTv_SdtuploadS3_body_Linklegnumero( )
   {
      return gxTv_SdtuploadS3_body_Linklegnumero ;
   }

   public void setgxTv_SdtuploadS3_body_Linklegnumero( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Linklegnumero = value ;
   }

   public String getgxTv_SdtuploadS3_body_Leglinktiporec( )
   {
      return gxTv_SdtuploadS3_body_Leglinktiporec ;
   }

   public void setgxTv_SdtuploadS3_body_Leglinktiporec( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Leglinktiporec = value ;
   }

   public boolean getgxTv_SdtuploadS3_body_Uploadhtml( )
   {
      return gxTv_SdtuploadS3_body_Uploadhtml ;
   }

   public void setgxTv_SdtuploadS3_body_Uploadhtml( boolean value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Uploadhtml = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtuploadS3_body_Bucket_name = "" ;
      gxTv_SdtuploadS3_body_N = (byte)(1) ;
      gxTv_SdtuploadS3_body_File_path = "" ;
      gxTv_SdtuploadS3_body_S3_path = "" ;
      gxTv_SdtuploadS3_body_File_name = "" ;
      gxTv_SdtuploadS3_body_Content_type = "" ;
      gxTv_SdtuploadS3_body_Aws_region = "" ;
      gxTv_SdtuploadS3_body_Htmlcontent = "" ;
      gxTv_SdtuploadS3_body_Leglinktiporec = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtuploadS3_body_N ;
   }

   public web.SdtuploadS3_body Clone( )
   {
      return (web.SdtuploadS3_body)(clone()) ;
   }

   public void setStruct( web.StructSdtuploadS3_body struct )
   {
      setgxTv_SdtuploadS3_body_Bucket_name(struct.getBucket_name());
      setgxTv_SdtuploadS3_body_File_path(struct.getFile_path());
      setgxTv_SdtuploadS3_body_S3_path(struct.getS3_path());
      setgxTv_SdtuploadS3_body_File_name(struct.getFile_name());
      setgxTv_SdtuploadS3_body_Content_type(struct.getContent_type());
      setgxTv_SdtuploadS3_body_Aws_region(struct.getAws_region());
      setgxTv_SdtuploadS3_body_Htmlcontent(struct.getHtmlcontent());
      setgxTv_SdtuploadS3_body_Clicod(struct.getClicod());
      setgxTv_SdtuploadS3_body_Empcod(struct.getEmpcod());
      setgxTv_SdtuploadS3_body_Liqnro(struct.getLiqnro());
      setgxTv_SdtuploadS3_body_Linklegnumero(struct.getLinklegnumero());
      setgxTv_SdtuploadS3_body_Leglinktiporec(struct.getLeglinktiporec());
      setgxTv_SdtuploadS3_body_Uploadhtml(struct.getUploadhtml());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtuploadS3_body getStruct( )
   {
      web.StructSdtuploadS3_body struct = new web.StructSdtuploadS3_body ();
      struct.setBucket_name(getgxTv_SdtuploadS3_body_Bucket_name());
      struct.setFile_path(getgxTv_SdtuploadS3_body_File_path());
      struct.setS3_path(getgxTv_SdtuploadS3_body_S3_path());
      struct.setFile_name(getgxTv_SdtuploadS3_body_File_name());
      struct.setContent_type(getgxTv_SdtuploadS3_body_Content_type());
      struct.setAws_region(getgxTv_SdtuploadS3_body_Aws_region());
      struct.setHtmlcontent(getgxTv_SdtuploadS3_body_Htmlcontent());
      struct.setClicod(getgxTv_SdtuploadS3_body_Clicod());
      struct.setEmpcod(getgxTv_SdtuploadS3_body_Empcod());
      struct.setLiqnro(getgxTv_SdtuploadS3_body_Liqnro());
      struct.setLinklegnumero(getgxTv_SdtuploadS3_body_Linklegnumero());
      struct.setLeglinktiporec(getgxTv_SdtuploadS3_body_Leglinktiporec());
      struct.setUploadhtml(getgxTv_SdtuploadS3_body_Uploadhtml());
      return struct ;
   }

   protected byte gxTv_SdtuploadS3_body_N ;
   protected short gxTv_SdtuploadS3_body_Empcod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtuploadS3_body_Clicod ;
   protected int gxTv_SdtuploadS3_body_Liqnro ;
   protected int gxTv_SdtuploadS3_body_Linklegnumero ;
   protected String gxTv_SdtuploadS3_body_Content_type ;
   protected String gxTv_SdtuploadS3_body_Aws_region ;
   protected String gxTv_SdtuploadS3_body_Leglinktiporec ;
   protected String sTagName ;
   protected boolean gxTv_SdtuploadS3_body_Uploadhtml ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtuploadS3_body_Htmlcontent ;
   protected String gxTv_SdtuploadS3_body_Bucket_name ;
   protected String gxTv_SdtuploadS3_body_File_path ;
   protected String gxTv_SdtuploadS3_body_S3_path ;
   protected String gxTv_SdtuploadS3_body_File_name ;
}

